package com.example.preview.service.impl;/*
@author lujinyi
@creatr 2022-04-2022/4/7-16:32
*/

import com.example.preview.entity.CmfAfVoucherAttachment;
import com.example.preview.entity.Preview;
import com.example.preview.service.PreviewService;
import com.example.preview.util.HttpUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class PreviewServiceImpl  implements PreviewService {
    @Autowired
    private Preview preview;

    private static Logger logger = LoggerFactory.getLogger(PreviewServiceImpl.class);

    /**
     * 缓存大小1M
     */
    private static final int BUFFER_SIZE = 2 * 1024 * 1024;

    /**
     * 文件下载默认编码.
     */
    public static final String ENC = "UTF-8";

    @Override
    public Map<String,String> postParams( String filepath, String type, String fileName) {
        Map<String,String> h=new HashMap<>();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result=null;
        String url=null;
        try{
            HttpPost httpPost = new HttpPost(preview.getUrl());
            MultipartEntityBuilder mEntityBuilder=MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            mEntityBuilder.setCharset(Charset.forName("UTF-8"));
//            FileBody fileBody = new FileBody(new File(filepath+"/"+fileName));
            FileBody fileBody = new FileBody(new File(filepath));
            mEntityBuilder.addPart("file",fileBody);
            StringBody comment = new StringBody(type, ContentType.APPLICATION_JSON);
            StringBody htmlTitle = new StringBody(fileName, ContentType.APPLICATION_JSON);
            StringBody htmlName = new StringBody(fileName, ContentType.APPLICATION_JSON);
            mEntityBuilder.addPart("htmlTitle", htmlTitle);
            mEntityBuilder.addPart("htmlName", htmlName);
            mEntityBuilder.addPart("convertType",comment);

            HttpEntity repEntity=mEntityBuilder.build();
            httpPost.setEntity(repEntity);
            response=httpClient.execute(httpPost);
            String entityString = EntityUtils.toString(response.getEntity());
            JSONObject fromObject = JSONObject.fromObject(entityString);
            logger.info("接口返回：" + fromObject);
            HttpUtil.judgeStatus(response, httpPost, fromObject);
            int stuatsCode=response.getStatusLine().getStatusCode();
            if (stuatsCode == HttpStatus.SC_OK) {
                HttpEntity resEntity=response.getEntity();
                EntityUtils.consume(resEntity);
                result= fromObject.getString("data");
            }
            h.put("data",result);
        }catch (Exception e) {
            h.put("msg",e.getMessage());
            e.printStackTrace();
        }finally {
            HttpClientUtils.closeQuietly(httpClient);
            HttpClientUtils.closeQuietly(response);
        }
        return h;
    }

    @Override
    public HttpServletResponse download(String path,String name, HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);


            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(name.getBytes(),"ISO8859-1"));
//            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            response=null;
            ex.printStackTrace();
        }
        return response;
    }

    @Override
    public HttpServletResponse downloadzip(List<Preview> previewList, HttpServletResponse response)  {
        try {
            String fileName = new String("附件.zip".getBytes("gb2312"), "iso-8859-1");
            response.reset();
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("name", fileName);
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            response.setDateHeader("Expires", 0);
            response.setHeader("Content-Disposition", "attachment;filename=download.zip");
            response.setCharacterEncoding("UTF-8");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        /*获取zip的输出流*/
        ServletOutputStream out= null;
        FileInputStream fis=null;
        ZipOutputStream zipOut=null;
        try {
            out = response.getOutputStream();
            zipOut=new ZipOutputStream(out);

            for (int i = 0; i < previewList.size(); i++) {
                Preview preview = previewList.get(i);
                File file = new File(preview.getPath());
                fis= new FileInputStream(file);
                zipOut.putNextEntry(new ZipEntry(preview.getName()));
                int len=0;
                byte[] b=new byte[1024];
                while ((len=fis.read(b)) != -1) {
                    zipOut.write(b, 0, len);
                }
            }
        } catch (IOException e) {
            response=null;
            e.printStackTrace();
        }finally {
            try {
                zipOut.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return response;
    }

    @Override
    public Map<String, List<CmfAfVoucherAttachment>> fileExists(List<CmfAfVoucherAttachment> cmfAfVoucherAttachmentList) {
        Map<String, List<CmfAfVoucherAttachment>> resultMap = new HashMap<>();
        List<CmfAfVoucherAttachment> fileExists=new ArrayList<>();
        for (CmfAfVoucherAttachment cmfAfVoucherAttachment : cmfAfVoucherAttachmentList) {
            File file=null;
            if (cmfAfVoucherAttachment.getAttachmentPath().indexOf(".pdf") > 0 ){
                file = new File(cmfAfVoucherAttachment.getAttachmentPath());
            } else {
                file =new File(cmfAfVoucherAttachment.getAttachmentPath() + "/" + cmfAfVoucherAttachment.getAttachmentName());
            }
            if (!file.exists()) {
                fileExists.add(cmfAfVoucherAttachment);
            }
        }
        if (!fileExists.isEmpty()) {
            resultMap.put("false",fileExists);
        }else {
            resultMap.put("true",null);
        }
        return resultMap;
    }

    @Override
    public HttpServletResponse downloadStreamFile(HttpServletResponse response, String filePath, String fileName) throws Exception {
        InputStream fileIn = null;
        OutputStream fileOut = null;
        try {
            File file = new File(filePath);
            if (file.exists()) {
                fileIn = new FileInputStream(file);
                fileOut = response.getOutputStream();
                // 设置响应信息
                response.addHeader("Content-Disposition", "attachment;filename=\""
                        + URLEncoder.encode(fileName, ENC) + "\"");
                response.setContentType("application/octet-stream");
                response.setHeader("Accept-Ranges", "bytes");
                byte[] buff = new byte[BUFFER_SIZE];
                int len = 0;
                while ((len = fileIn.read(buff)) != -1) {
                    fileOut.write(buff, 0, len);
                }
                fileOut.flush();
            } else {
                throw new FileNotFoundException("filePath=" + filePath);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (fileOut != null) {
                fileOut.close();
            }
            if (fileIn != null) {
                fileIn.close();
            }
        }
        return response;
    }
}

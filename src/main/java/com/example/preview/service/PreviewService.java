package com.example.preview.service;/*
@author lujinyi
@creatr 2022-04-2022/4/7-16:31
*/


import com.example.preview.entity.CmfAfVoucherAttachment;
import com.example.preview.entity.Preview;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public interface PreviewService{

    /**
     * 获取文件预览地址
     * @param filepath 下载的文件地址
     * @param type  保存的文件类型
     * @param fileName 下载的文件名
     * @return
     */
    Map<String,String> postParams(String filepath, String type, String fileName);

    /**
     * 单个下载文件
     * @param path 文件地址
     * @param response
     * @return
     */
    HttpServletResponse download(String path,String name, HttpServletResponse response);

    /**
     * 批量下载文件
     * @param previewList 文件批量地址
     * @param response
     * @return
     */
    HttpServletResponse downloadzip(List<Preview> previewList, HttpServletResponse response) ;

    /**
     * 判断文件是否存在
     * @param previewList
     * @return
     */
    Map<String,List<CmfAfVoucherAttachment>> fileExists(List<CmfAfVoucherAttachment> cmfAfVoucherAttachmentList);


    /**
     * 下载株洲池文件
     *
     * @param response 响应
     * @param filePath 文件路径
     * @param fileName 文件名
     * @return 文件流
     */
    HttpServletResponse downloadStreamFile(HttpServletResponse response, String filePath, String fileName) throws Exception;
}


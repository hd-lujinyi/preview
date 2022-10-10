package com.example.preview.util;/*
@author lujinyi
@creatr 2022-04-2022/4/7-15:58
*/


import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;

public class HttpUtil {
    /**
     * 判断当前响应状态
     *
     * @param httpResponse 响应数据
     * @param request      请求数据
     * @param result       解析后的响应报文结果
     */
    public static void judgeStatus(HttpResponse httpResponse, HttpPost request, JSONObject result) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            //当调用接口返回状态非200，应该终止当前链接，否则会出现服务端无法响应且存在于连接池中
            request.abort();
            String error = null;
            String errorDescription = null;
            if (result.has("error")) {
                error = result.getString("error");
            }
            if (result.has("error_description")) {
                errorDescription = result.getString("error_description");
            }
            if ("invalid_token".equals(error) || statusCode == HttpStatus.SC_UNAUTHORIZED) {
                throw new CmfClmTokenException(error, errorDescription);
            } else {
                throw new RuntimeException("当前请求响应状态不正常！");
            }

        }
    }
}
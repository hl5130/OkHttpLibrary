package com.hongliang.okhttp.request;

import java.util.Map;

import okhttp3.Request;

/**
 * Created by hongliang on 2017/1/30.
 * 负责创建各种请求类
 */

public class CommonRequset {
    /**
     *  创建get请求类
     * @param url 请求地址
     * @param params 请求参数
     */
    public static Request createGetRequest(String url, RequestParams params){
        // www.baidu.com?id=1999&name=skdjf
        StringBuilder urlBuilder = new StringBuilder(url).append("?");
        if (params != null){
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        return new Request.Builder().url(urlBuilder.substring(0,urlBuilder.length()-1)).get().build();
    }
}

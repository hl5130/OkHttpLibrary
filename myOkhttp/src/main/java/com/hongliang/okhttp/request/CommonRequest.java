package com.hongliang.okhttp.request;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by hongliang on 2017/1/30.
 * 负责创建各种请求类
 */

public class CommonRequest {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8"); //请求方式

    /**
     * 创建get请求类
     *
     * @param url    请求地址
     * @param params 请求参数
     */
    public static Request createGetRequest(String url, RequestParams params) {
        StringBuilder urlBuilder = new StringBuilder(url).append("?");
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }

        // TODO: 2017/2/1 此处设置header
        return new Request.Builder()
                .url(urlBuilder.substring(0, urlBuilder.length() - 1))
                .get()
                .build();
    }

    public static Request createPostRequest(String url, RequestParams params) {
//        FormBody.Builder forBodyBuilder = new FormBody.Builder();
//        for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
//            forBodyBuilder.add(entry.getKey(), entry.getValue());
//        }
//        Headers.Builder headerBuilder = new Headers.Builder();
//        headerBuilder.add("token","qianfan");
        RequestBody requestBody = null;
        if (params.urlParams != null){
            String jsonStr = new Gson().toJson(params.urlParams);
            requestBody = RequestBody.create(JSON,jsonStr);

        }
        return new Request.Builder()
                .url(url)
                .addHeader("token","qianfan")
                .post(requestBody)
                .build();

    }

    public void ss(){}


}

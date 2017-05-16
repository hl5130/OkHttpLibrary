package com.hongliang.okhttp.request;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by hongliang on 2017/1/30.
 * 负责创建各种请求类
 */

// TODO: 2017/5/16  用于创建各种请求，需要根据实际情况来创建；
public class CommonRequest {

    // TODO: 2017/5/16   1、设置请求体的格式
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8"); //请求方式为json格式

    // TODO: 2017/5/16   2、创建请求方式
    /**
     * 因为每个公司的要求不一样，所以需要根据实际情况来创建；
     *  例如：1、有的需要设置 header，有的不需要
     *       2、有是通过表单提交，而有的则是通过json提交
     *
     *  下面是两个例子：
     *      第一个例子适用于无header的get请求
     *      第二个是我的测试数据，不适用；
     */

    /**
     * 创建get请求类
     *
     * @param url    请求地址
     * @param params 请求参数
     * @return Request
     */
    public static Request createGetRequest(String url, RequestParams params) {
        StringBuilder urlBuilder = new StringBuilder(url).append("?");
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        return new Request.Builder()
                .url(urlBuilder.substring(0, urlBuilder.length() - 1))
                .get()
                .build();
    }


    /**
     *  创建post请求类
     *      要求：有header，header的值随时变化的，所以需要传入；
     *           向服务传输的数据是json，不是表单
     *
     * @param url 请求地址
     * @param params 请求参数
     * @param token  头部header
     * @return Request
     */
    public static Request createPostRequest(String url, RequestParams params,String token) {
        RequestBody requestBody = null;
        if (params.urlParams != null){
            String jsonStr = new Gson().toJson(params.urlParams);
            requestBody = RequestBody.create(JSON,jsonStr);
        }
        return new Request.Builder()
                .url(url)
                .addHeader("Authorization",token)
                .post(requestBody)
                .build();

    }

    // TODO: 2017/5/16  文件的上传与下载还未写，后期更新

}

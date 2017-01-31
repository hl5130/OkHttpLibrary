package com.hongliang.okhttp.request;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hongliang on 2017/1/30.
 * 封装的请求参数
 */

public class RequestParams {

    //普通请求的参数
    protected ConcurrentHashMap<String,String> urlParams = new ConcurrentHashMap<>();

    //文件上传和下载请求的参数
    protected ConcurrentHashMap<String,Object> fileParams = new ConcurrentHashMap<>();

    public RequestParams() {this((Map<String, String>) null);}

    ////////////////////////////////普通请求////////////////////////////////////////////////////
    public RequestParams(Map<String,String> source) {
        if (source != null){
            for (Map.Entry<String, String> entry: source.entrySet()){
                put(entry.getKey(),entry.getValue());
            }
        }
    }
    private void put(String key, String value) {
        if (key != null && value != null){
            urlParams.put(key,value);
        }
    }


    ////////////////////////////////文件上传与下载请求///////////////////////////////////////////
//    public RequestParams(Map<String,Object> source){
//
//    }


}

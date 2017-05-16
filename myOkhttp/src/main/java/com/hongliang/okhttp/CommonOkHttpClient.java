package com.hongliang.okhttp;

import com.hongliang.okhttp.listener.DisposeDataHandler;
import com.hongliang.okhttp.listener.DisposeDataListener;
import com.hongliang.okhttp.request.CommonRequest;
import com.hongliang.okhttp.request.RequestParams;
import com.hongliang.okhttp.response.CommonJsonCallBack;
import com.hongliang.okhttp.response.CommonJsonCallBack2;
import com.hongliang.okhttp.response.DataJsonCallBack;
import com.hongliang.okhttp.response.TokenJsonCallBack;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;

/**
 * Created by hongliang on 2017/1/30.
 * 管理框架，并对外放出公共方法
 */

public class CommonOkHttpClient {

    private static final int TIME_OUT = 30;
    private static OkHttpClient mOkHttpClient;

    static {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.followRedirects(true); //开启重连机制

        mOkHttpClient = okHttpClientBuilder.build();

    }

    /**
     *  post请求，直接将结果丢给应用层
     *
     * @param url  请求地址
     * @param params    请求参数
     * @param listener  回调接口
     * @return  call
     */
    public static Call post(String url, String token,HashMap<String,String> params, DisposeDataListener listener){
        Call call = mOkHttpClient.newCall(
                CommonRequest.createPostRequest(url,new RequestParams(params),token)
        );
        call.enqueue(new CommonJsonCallBack2(new DisposeDataHandler(listener)));
        return call;
    }

    /**
     *  post请求，将结果转换成对应的类之后，再丢给应用层
     *
     * @param url  请求地址
     * @param params    请求参数
     * @param listener  回调接口
     * @param c     要转换的类
     * @return call
     */
    public static Call post(String url, String token,HashMap<String,String> params, DisposeDataListener listener,Class<?> c){
        Call call = mOkHttpClient.newCall(
                CommonRequest.createPostRequest(url,new RequestParams(params),token)
        );
        call.enqueue(new CommonJsonCallBack2(new DisposeDataHandler(listener,c)));
        return call;
    }


    /**
     *  get请求，直接将结果丢给应用层
     *
     * @param url  请求地址
     * @param params    请求参数
     * @param listener  回调接口
     * @return  call
     */
    public static Call get(String url, HashMap<String,String> params, DisposeDataListener listener){
        Call call = mOkHttpClient.newCall(
                CommonRequest.createGetRequest(url,new RequestParams(params))
        );
        call.enqueue(new CommonJsonCallBack(new DisposeDataHandler(listener)));
        return call;
    }


    /**
     *  get请求，需要将结果转换成对应的类，再丢给应用层
     *
     * @param url  请求地址
     * @param params    请求参数
     * @param listener  回调接口
     * @param c     要转换的类
     * @return call
     */
    public static Call get(String url, HashMap<String,String> params, DisposeDataListener listener,Class<?> c){
        Call call = mOkHttpClient.newCall(
                CommonRequest.createGetRequest(url,new RequestParams(params))
        );
        call.enqueue(new CommonJsonCallBack(new DisposeDataHandler(listener,c)));
        return call;
    }

    // TODO: 2017/5/16 上传和下载文件——后期更新
}

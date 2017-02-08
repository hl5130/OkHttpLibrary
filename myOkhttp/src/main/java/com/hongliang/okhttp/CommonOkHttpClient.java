package com.hongliang.okhttp;

import com.hongliang.okhttp.listener.DisposeDataHandler;
import com.hongliang.okhttp.response.CommonJsonCallBack;
import com.hongliang.okhttp.response.CommonJsonCallBack2;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by hongliang on 2017/1/30.
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

    public static Call get(Request request, DisposeDataHandler handler){
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallBack(handler));
        return call;
    }

    public static Call post(Request request,DisposeDataHandler handler){
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallBack2(handler));
        return call;
    }
}

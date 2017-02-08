package com.hongliang.okhttp.listener;

/**
 * Created by hongliang on 2017/1/30.
 * 响应接口
 */

public interface DisposeDataListener{
    void onSuccess(Object responseObj);
    void onFailure(Object errorObj);
}

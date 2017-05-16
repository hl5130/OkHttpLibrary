package com.hongliang.okhttp.listener;

/**
 * Created by hongliang on 2017/1/30.
 * 响应接口
 */

// TODO: 2017/5/16  响应接口，可以做添加和编辑

public interface DisposeDataListener{
    void onSuccess(Object responseObj);
    void onFailure(Object errorObj);
}

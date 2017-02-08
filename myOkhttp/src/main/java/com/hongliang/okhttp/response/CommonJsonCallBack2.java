package com.hongliang.okhttp.response;

import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;
import com.hongliang.okhttp.exception.OkHttpException;
import com.hongliang.okhttp.listener.DisposeDataHandler;
import com.hongliang.okhttp.listener.DisposeDataListener;
import com.hongliang.okhttp.log.OkHttpLog;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by hongliang on 2017/1/30.
 * 返回的json类型解析类
 */

public class CommonJsonCallBack2 implements Callback {

    // TODO: 2017/1/30 此处的参数主要根据自身的业务逻辑来设置
    protected final String RESULT_CODE = "code"; // 有返回则对于http请求来说是成功的，但还有可能是业务逻辑上的错误
    protected final int RESULT_CODE_VALUE = 0;
    protected final String ERROR_MSG = "msg";
    protected final String EMPTY_MSG = "";
    protected final String RESPONSE_EMPTY_MSG ="请求到的数据为空";


    /**
     * the java layer exception, do not same to the logic error
     */
    protected final int NETWORK_ERROR = -1; // the network relative error
    protected final int JSON_ERROR = -2; // the JSON relative error
    protected final int OTHER_ERROR = -3; // the unknow error


    private Class<?> mClass;
    private DisposeDataListener mListener;

    /**
     * 由于所有的操作都是在非UI线程中进行的。
     * 所以需要声明一个handler
     */
    private Handler mDeliveryHandler;

    public CommonJsonCallBack2(DisposeDataHandler handler) {
        this.mClass = handler.mClass;
        this.mListener = handler.mListener;
        this.mDeliveryHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onFailure(Call call, final IOException e) {
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFailure(new OkHttpException(NETWORK_ERROR, e));
            }
        });

        OkHttpLog.error("网络请求失败");
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {

        final String result = response.body().string();
        OkHttpLog.error("网络请求成功，结果是：" + result);
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                dealWithResult(result);
            }
        });
    }

    private void dealWithResult(Object object) {
        if (object == null) {
            mListener.onFailure(new OkHttpException(NETWORK_ERROR, RESPONSE_EMPTY_MSG));
            return;
        }

        try {
            JSONObject result = new JSONObject(object.toString()); //将返回的数据转换成json对象
            if (result.has(RESULT_CODE)) { //判断对象中是否有RESULT_CODE对应的字段
                if (result.optInt(RESULT_CODE) == RESULT_CODE_VALUE){
                    String result1 = object.toString();
                    if (mClass == null) { //不需要转换对象的时候，直接回调onSuccess接口
                        mListener.onSuccess(result1);
                    } else {
                        Object obj = JSON.parseObject(result1, mClass);
                        if (obj != null){
                            mListener.onSuccess(obj);
                        }else {
                            mListener.onFailure(new OkHttpException(JSON_ERROR,EMPTY_MSG));
                        }
                    }
                }else {
                    if (result.has(ERROR_MSG)){
                        mListener.onFailure(new OkHttpException(result.optInt(RESULT_CODE),result.optString(ERROR_MSG)));
                    }else {
                        mListener.onFailure(new OkHttpException(result.optInt(RESULT_CODE), RESPONSE_EMPTY_MSG));
                    }
                }

            } else { //没有对应的字段，就说明发生了错误
                if (result.has(ERROR_MSG)) {
                    mListener.onFailure(new OkHttpException(OTHER_ERROR, result.opt(ERROR_MSG)));
                }
            }
        } catch (Exception e) {
            mListener.onFailure(new OkHttpException(OTHER_ERROR, e.getMessage()));
        }
    }
}

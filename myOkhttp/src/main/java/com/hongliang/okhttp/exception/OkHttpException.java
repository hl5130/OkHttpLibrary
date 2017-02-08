package com.hongliang.okhttp.exception;

/**
 * Created by hongliang on 2017/1/30.
 * 自定义框架的异常
 */

public class OkHttpException extends Exception {

    private static final long serialVersionUID = 1L;//串型号

    private int code;
    private Object msg;

    public OkHttpException(int code, Object msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getEcode(){
        return code;
    }

    public Object getEmsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "OkHttpException{" +
                "code=" + code +
                ", msg=" + msg +
                '}';
    }
}

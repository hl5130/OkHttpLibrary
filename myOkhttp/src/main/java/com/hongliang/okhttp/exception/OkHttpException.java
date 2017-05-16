package com.hongliang.okhttp.exception;

/**
 * Created by hongliang on 2017/1/30.
 * 自定义框架的异常
 */
// TODO: 2017/5/16 自定义框架的异常信息

public class OkHttpException extends Exception {

    private static final long serialVersionUID = 1L;//串型号

    private int code;
    private Object msg;

    public OkHttpException(int code, Object msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     *  获取code
     * @return code响应编号
     */
    public int getEcode(){
        return code;
    }

    /**
     *  获取异常信息
     * @return  异常信息，String
     */
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

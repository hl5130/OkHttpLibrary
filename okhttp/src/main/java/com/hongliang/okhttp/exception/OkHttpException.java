package com.hongliang.okhttp.exception;

/**
 * Created by hongliang on 2017/1/30.
 * 自定义框架的异常
 */

public class OkHttpException extends Exception {

    private static final long serialVersionUID = 1L;//串型号

    private int ecode;
    private Object emsg;

    public OkHttpException(int ecode, Object emsg) {
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public int getEcode(){
        return ecode;
    }

    public Object getEmsg() {
        return emsg;
    }
}

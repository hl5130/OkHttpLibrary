package com.hongliang.okhttp.listener;

/**
 * Created by hongliang on 2017/1/30.
 * 封装响应回调和字节码对象
 */
// TODO: 2017/5/16 封装响应的回调
public class DisposeDataHandler {

    public DisposeDataListener mListener = null;
    public Class<?> mClass = null; //class字节码


    /**
     *  直接将结果返回到应用层
     * @param mListener 响应接口
     */
    public DisposeDataHandler(DisposeDataListener mListener) {
        this.mListener = mListener;
    }

    /**
     *  用于将结果转换成对应的对象之后，再返回到应用层
     * @param mListener 响应接口
     * @param mClass    转换的对象
     */
    public DisposeDataHandler(DisposeDataListener mListener, Class<?> mClass) {
        this.mListener = mListener;
        this.mClass = mClass;
    }
}

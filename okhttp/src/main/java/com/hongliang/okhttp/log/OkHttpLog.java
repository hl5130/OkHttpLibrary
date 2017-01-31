package com.hongliang.okhttp.log;

import android.util.Log;

/**
 * Created by hongliang on 2017/1/31.
 */

public class OkHttpLog {

    private static final String LOG_TAG = "OkHttpLog";

    public static void error(String msg){
        Log.e(LOG_TAG,msg);
    }
}

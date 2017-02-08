package com.example.hongliang.okhttpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hongliang.okhttp.CommonOkHttpClient;
import com.hongliang.okhttp.exception.OkHttpException;
import com.hongliang.okhttp.listener.DisposeDataHandler;
import com.hongliang.okhttp.listener.DisposeDataListener;
import com.hongliang.okhttp.request.CommonRequest;
import com.hongliang.okhttp.request.RequestParams;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_get, btn_post;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        btn_get = (Button) findViewById(R.id.btn_get);
        btn_post = (Button) findViewById(R.id.btn_post);
        textView = (TextView) findViewById(R.id.tv_result);


        btn_post.setOnClickListener(this);
        btn_get.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                getRequest();
                break;
            case R.id.btn_post:
                postRequest();
                break;
            case R.id.tv_result:
                break;
        }
    }

    private void getRequest() {
        CommonOkHttpClient.get("https://api.douban.com/v2/movie/in_theaters", null, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                textView.setText("");
                textView.setText(responseObj.toString());
                Log.d("tag", responseObj.toString());
            }

            @Override
            public void onFailure(Object errorObj) {
                textView.setText("连接失败");
                Log.e("tag", "连接失败");
            }
        });
    }

    private void postRequest() {
        HashMap<String, String> params = new HashMap<>();
        params.put("number", "5");
        params.put("type", "0");
        CommonOkHttpClient.post("https://go.1000fun.com/api/api/app/v2.0/member/subject/list", params, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                textView.setText("");
                textView.setText(responseObj.toString());
                Log.d("tag", responseObj.toString());
            }

            @Override
            public void onFailure(Object errorObj) {
                textView.setText("连接失败");
                Log.e("tag", errorObj.toString());
            }
        });
    }
}

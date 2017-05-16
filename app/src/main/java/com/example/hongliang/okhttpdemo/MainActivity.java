package com.example.hongliang.okhttpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hongliang.okhttp.CommonOkHttpClient;
import com.hongliang.okhttp.listener.DisposeDataHandler;
import com.hongliang.okhttp.listener.DisposeDataListener;
import com.hongliang.okhttp.request.CommonRequest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_get,btn_post;
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
        switch (v.getId()){
            case R.id.btn_get:
                getRequest();
                break;
            case R.id.btn_post:
                break;
            case R.id.tv_result:
                break;
        }
    }

    private void getRequest() {
        String url = "https://api.douban.com/v2/movie/in_theaters";
        //https://api.douban.com/v2/movie/in_theaters

        CommonOkHttpClient.get(url, null, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                textView.setText("");
                textView.setText(responseObj.toString());
                Log.d("tag",responseObj.toString());
            }

            @Override
            public void onFailure(Object errorObj) {
                textView.setText("连接失败");
                Log.e("tag","连接失败");
            }
        });
    }
}

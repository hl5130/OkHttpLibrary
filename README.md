# OkHttpLibrary
### 简介
#### 这是一个网络框架，底层是okhttp实现的。

---
### 框架结构
- com.hongliang.okhttp (总目录)
    - exception （网络框架异常包）
        - OkhttpException
    - listener  （网络框架接口包）
        - DisposeDataHandler
        - DisposeDataListener
    - log       （网络框架日志包）
        - OkHttpLog
    - request   （网络框架请求类包）
        - CommonRequest
        - RequestParams
    - response  （网络框架响应类包）
        - CommonJsonCallBack
    - CommonOkHttpClient (对外开放的类)

response包中的类，是根据实际业务逻辑创建的，里面有几个类是列子；

---
### 使用方法
1. 下载zip，并解压
2. 导入 myOkhttp 就行了
3. get使用实例
```
private void getRequest() {
        String url = "https://api.douban.com/v2/movie/in_theaters";
        CommonOkHttpClient.get(url, null, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.d("tag",responseObj.toString());
            }

            @Override
            public void onFailure(Object errorObj) {
                Log.e("tag","连接失败");
            }
        });
    }
```

4. post使用实例
```
private void postRequest() {
        String url = "https://api.douban.com/v2/movie/in_theaters";
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("data","测试数据");
        CommonOkHttpClient.post(url, hashMap, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                Log.d("tag",responseObj.toString());
            }

            @Override
            public void onFailure(Object errorObj) {
                Log.e("tag","连接失败");
            }
        });
    }
```

---

### 后续更新
1. 添加文件上传和下载功能

---
### 合作
开发的最大乐趣是一群人做同一件事，希望你们能加入进来，一起开发。
#### QQ：281332545   
#### 验证信息：gitHub_okhttp

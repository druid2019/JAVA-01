package com.example.memo.homework.third20210129.nio02.src.main.java.io.github.kimmking.gateway.outbound.okhttp;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkhttpOutboundHandler {
    static OkHttpClient okHttpClient = new OkHttpClient();

    /**
     * post使用的json头
     */
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    /**
     * get接口操作方法     *
     *
     * @param url 接口地址
     * @return
     * @throws IOException
     */
    public static String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println("GET");
            return response.body().string();
        } else {
            throw new IOException("错误码：" + response);
        }
    }
}

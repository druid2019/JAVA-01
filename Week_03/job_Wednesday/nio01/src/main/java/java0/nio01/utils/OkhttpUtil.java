package com.example.memo.homework.third20210129.src.main.java.java0.nio01.utils;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/1/26 10:50
 * @Description ${description}
 */
public class OkhttpUtil {
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

    public static void main(String[] args) {
        String url = "http://localhost:8801";
        try {
            System.out.println(get(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

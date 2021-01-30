package com.example.memo.homework.third20210129.src.main.java.java0.nio01.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/1/26 11:25
 * @Description ${description}
 */
public class OkhttpThreadUtil {
    private static void sendRequestWithOkHttp(String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 创建一个OkHttp实例
                    OkHttpClient client = new OkHttpClient();
                    // 创建一个Request对象，这是发起一条HTTP请求的前提
                    Request request = new Request.Builder()
                            .url(url)
                            .build();
                    // 调用OkHttpClient的necCall()方法来创建一个Call对象，并调用它的execute方法
                    // 来发送请求并获取服务器返回的数据
                    Response response = client.newCall(request).execute();
                    String responseDate = response.body().string();
                    System.out.println(responseDate);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        String url = "http://localhost:8801";
        try {
            sendRequestWithOkHttp(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

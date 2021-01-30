package com.example.memo.homework.third20210129.src.main.java.java0.nio01.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/1/24 14:30
 * @Description ${description}
 */
public class HttpGetUtils {
    /**
     * 发送GET请求
     *
     * @param url         请求URL
     * @return 响应结果
     */
    public static String doGet(String url) throws IOException {
        // Get请求
        HttpGet get = new HttpGet(url);
        // 请求配置
        get.setConfig(requestConfig());

        return getResult(get);
    }

    private static String getResult(HttpGet get) throws IOException {
        // Http客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 响应结果
        String result = EntityUtils.toString(httpClient.execute(get).getEntity());

        // 返回响应结果
        return result;
    }

    /**
     * 请求配置
     *
     * @return 请求配置
     */
    private static RequestConfig requestConfig() {
        return RequestConfig
                .custom()
                // 设置主机超时时间
                .setConnectionRequestTimeout(35000)
                // 请求超时时间
                .setSocketTimeout(60000)
                .build();
    }

    public static void main(String[] args) {
        String url = "http://localhost:8801";
        try {
            doGet(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

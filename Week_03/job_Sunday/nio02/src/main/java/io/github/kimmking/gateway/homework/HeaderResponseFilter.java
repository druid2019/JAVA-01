package com.example.memo.homework.third20210129.nio02.src.main.java.io.github.kimmking.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/1/30 21:16
 * @Description 作业，实现过滤器，下载文件
 */
public class HeaderResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("Content-Type", "application/download");
        response.headers().set("Content-Disposition", "attachment;filename=a.txt");
    }
}

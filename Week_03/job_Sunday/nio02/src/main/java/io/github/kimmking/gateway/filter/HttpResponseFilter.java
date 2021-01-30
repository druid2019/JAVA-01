package com.example.memo.homework.third20210129.nio02.src.main.java.io.github.kimmking.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public interface HttpResponseFilter {

    void filter(FullHttpResponse response);

}

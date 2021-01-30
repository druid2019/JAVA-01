package com.example.memo.homework.third20210129.nio02.src.main.java.io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface HttpRequestFilter {
    
    void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx);
    
}

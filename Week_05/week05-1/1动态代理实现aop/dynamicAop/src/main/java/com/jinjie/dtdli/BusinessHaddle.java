package com.jinjie.dtdli;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/18 19:41
 * @Description ${description}
 */
public class BusinessHaddle{

    public static void main(String[] args) {
        BusinessInterface businessInterface = new BusinessObject();

        InvocationHandler handler = new LogHandler(businessInterface);
        BusinessInterface proxy = (BusinessInterface) Proxy.newProxyInstance(
                businessInterface.getClass().getClassLoader(),
                businessInterface.getClass().getInterfaces(),
                handler
        );
        proxy.processBusiness();
    }
}

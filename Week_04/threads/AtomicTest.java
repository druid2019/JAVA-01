package com.example.memo.homework.fouth20210206;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/6 22:28
 * @Description ${description}
 */
public class AtomicTest {

    private static AtomicInteger a = new AtomicInteger(10);


    public static void main(String[] args) {
        System.out.println(factorial(a.get()));
    }

    private static int factorial(int a) {
        if (a == 1) return 1;
        return a * factorial(a - 1);
    }
}

package com.example.memo.homework.fouth20210206;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/6 20:40
 * @Description 求n的阶乘
 * */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int a = 10;
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = factorial(a);
                return result;
            }
        });

        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }

    private static int factorial(int a) {
        if (a == 1) return 1;
        return a * factorial(a - 1);
    }
}

package com.example.memo.homework.fouth20210206;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/6 22:44
 * @Description ${description}
 */
public class CountDownLatchTest implements Runnable{

    private static int a = 10;
    private CountDownLatch latch;
    public CountDownLatchTest(CountDownLatch latch) {
        this.latch = latch;
    }

    private static int factorial(int a) {
        if (a == 1) return 1;
        return a * factorial(a - 1);
    }

    @Override
    public void run() {
        Integer mills = new Random().nextInt(1000);
        try {
            TimeUnit.MILLISECONDS.sleep(mills);
            factorial(a);
            this.latch.countDown();
            System.out.println("我的任务OK了：" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CountDownLatch latch = new CountDownLatch(a);
        CompletableFuture<Void> future = CompletableFuture.runAsync(new CountDownLatchTest(latch));
        latch.await();
        System.out.println(future.get());
    }
}

package com.example.memo.homework.fouth20210206;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/6 23:06
 * @Description ${description}
 */
public class CyclicBarrierTest implements Runnable {

    private static int a = 10;
    private CyclicBarrier barrier;
    public CyclicBarrierTest(CyclicBarrier barrier) {
        this.barrier = barrier;
    }
    @Override
    public void run() {
        Integer mills = new Random().nextInt(1000);
        try {
            TimeUnit.MILLISECONDS.sleep(mills);
            factorial(a);
            this.barrier.await();
            System.out.println("开吃：" + Thread.currentThread().getName());
            TimeUnit.MILLISECONDS.sleep(mills);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int factorial(int a) {
        if (a == 1) return 1;
        return a * factorial(a - 1);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(a);
        List<CompletableFuture> list = new ArrayList<>(a);
        for (int i=0; i < a; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(new CyclicBarrierTest(barrier));
            list.add(future);
        }
        for (CompletableFuture future: list) {
            System.out.println( future.get());
        }
        barrier.reset();
    }
}

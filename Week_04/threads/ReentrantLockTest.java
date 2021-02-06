package com.example.memo.homework.fouth20210206;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/6 22:00
 * @Description ${description}
 */
public class ReentrantLockTest {

    private static int a = 10;
    // 可重入锁+公平锁
    private static Lock lock = new ReentrantLock(true);

    public static int facGet() {
        try {
            lock.lock();
            return factorial(a);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        int loop = 100;
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        IntStream.range(0,loop).parallel().forEach(i -> reentrantLockTest.facGet());
//        System.out.println(facGet());
    }


    private static int factorial(int a) {
        if (a == 1) return 1;
        return a * factorial(a - 1);
    }
}

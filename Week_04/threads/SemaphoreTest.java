package com.example.memo.homework.fouth20210206;

import java.util.concurrent.Semaphore;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/6 22:34
 * @Description ${description}
 */
public class SemaphoreTest {

    private static int a = 10;

    private static Semaphore readSemaphore = new Semaphore(100, true);
    private static Semaphore writeSemaphore = new Semaphore(1);

    public static int facWriteGet() {
        try {
            writeSemaphore.acquireUninterruptibly();
            return factorial(a);
        } finally {
            writeSemaphore.release();
        }
    }

    public static int facReadGet() {
        try {
            readSemaphore.acquireUninterruptibly();
            return factorial(a);
        } finally {
            readSemaphore.release();
        }
    }

    public static void main(String[] args) {
        System.out.println(facWriteGet());
        System.out.println(facReadGet());
    }

    private static int factorial(int a) {
        if (a == 1) return 1;
        return a * factorial(a - 1);
    }
}

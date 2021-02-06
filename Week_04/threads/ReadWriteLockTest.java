package com.example.memo.homework.fouth20210206;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/6 22:11
 * @Description 读写锁
 */
public class ReadWriteLockTest {

    private static int a = 10;
    // 可重入-读写锁-公平锁
    private static ReadWriteLock lock = new ReentrantReadWriteLock(true);

    public static void main(String[] args) {
        System.out.println(facGet());
    }

    public static int facGet() {
        try {
//            lock.readLock().lock();  // 读锁；
//            lock.readLock().unlock();
            lock.writeLock().lock(); // 写锁；独占锁；被读锁排斥
            return factorial(a);
        } finally {
            lock.writeLock().unlock();

        }
    }

    private static int factorial(int a) {
        if (a == 1) return 1;
        return a * factorial(a - 1);
    }
}

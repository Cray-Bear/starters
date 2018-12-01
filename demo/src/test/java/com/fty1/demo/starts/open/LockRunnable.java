package com.fty1.demo.starts.open;

import com.fty1.lock.Fty1LockFactory;
import com.fty1.lock.provider.Fty1CacheLock;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class LockRunnable implements Runnable {


    private CyclicBarrier barrier;
    private String name;
    private Fty1LockFactory fty1LockFactory;

    public LockRunnable(CyclicBarrier barrier, Fty1LockFactory fty1LockFactory, String name) {
        super();
        this.barrier = barrier;
        this.name = name;
        this.fty1LockFactory = fty1LockFactory;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " 准备好了...");
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + " 起跑！");


        log.info("开始:{}", Thread.currentThread().getName());
        Fty1CacheLock lock = fty1LockFactory.buildFty1CacheLock();
        String key = "LOCK."+System.currentTimeMillis();
        if (lock.tryLock(key, 3)) {
            System.out.println(name + " 获得锁...");
            try {
                System.out.println("业务执行。。。。。");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                log.info("UNLOCKED:{}", Thread.currentThread().getName());
                lock.unLock(key);
                log.info("UNLOCKED:{}", Thread.currentThread().getName());
            }
        }
        System.out.println(name + " 到达终点!");
    }

}

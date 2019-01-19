package com.fty1.demo.starts.open;

import com.fty1.demo.lock.CacheLockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.CyclicBarrier;

@Slf4j
public class LockRunnable implements Runnable {


    private CyclicBarrier barrier;
    private String name;


    @Autowired
    private ApplicationContext applicationContext;


    public LockRunnable(CyclicBarrier barrier, String name) {
        super();
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {

        try {
            System.out.println(name + " 准备好了...");
            barrier.await();
        } catch (Exception e) {
          log.info("CyclicBarrier Exception");
        }
        CacheLockService cacheLockService =applicationContext.getBean(CacheLockService.class);
        cacheLockService.test();
    }

}

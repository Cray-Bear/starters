package com.fty1.demo.starts.open;

import com.fty1.demo.lock.CacheLockService;
import com.fty1.demo.lock.SpringUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;

@Slf4j
public class LockRunnable implements Runnable {


    private CyclicBarrier barrier;
    private String name;

    public LockRunnable(CyclicBarrier barrier, String name) {
        super();
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {


        CacheLockService cacheLockService = SpringUtil.getBean(CacheLockService.class);
        log.info(cacheLockService.getClass().getSimpleName());
        log.info("CyclicBarrier open");
        try {
            cacheLockService.test();
        } catch (Exception e) {
            log.info("run-",e);
        }

    }

}

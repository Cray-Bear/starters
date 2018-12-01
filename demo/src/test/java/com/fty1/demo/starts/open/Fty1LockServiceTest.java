package com.fty1.demo.starts.open;

import com.fty1.demo.DemoApplicationTests;
import com.fty1.lock.Fty1LockFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Slf4j
public class Fty1LockServiceTest extends DemoApplicationTests {

    @Autowired
    private Fty1LockFactory fty1LockFactory;

    @Test
    public void test() {

        CyclicBarrier barrier = new CyclicBarrier(5);

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.submit(new Thread(new LockRunnable(barrier, fty1LockFactory, i+"LOCK")));
        }
        //executor.shutdown();
    }

}

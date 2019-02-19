package com.fty1.demo.starts.open;

import com.fty1.demo.DemoApplicationTests;
import com.fty1.demo.lock.CacheLockService;
import com.fty1.lock.Fty1LockFactory;
import com.fty1.lock.provider.Fty1CacheLock;
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


    @Autowired
    private CacheLockService cacheLockService;




    @Test
    public void test() {

        for (int i = 0; i < 10000; i++) {
            cacheLockService.test();
        }
        // executor.shutdown();
    }

}

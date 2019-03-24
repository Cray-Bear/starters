package com.fty1.center.example.test.open;

import com.fty1.center.example.DemoApplicationTests;
import com.fty1.center.example.lock.CacheLockService;
import com.fty1.lock.Fty1LockFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


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

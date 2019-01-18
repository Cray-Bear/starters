package com.fty1.demo.lock;

import com.fty1.lock.Fty1LockFactory;
import com.fty1.lock.provider.Fty1CacheLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CacheLockService {


    @Autowired
    private Fty1LockFactory fty1LockFactory;

    public void test() {

        String key = "LOCK." + System.currentTimeMillis();

        Fty1CacheLock lock = fty1LockFactory.buildFty1CacheLock();

        if (lock.tryLock(key)) {

            log.info("执行业务");
            try {

            } catch (Exception e) {

            } finally {
                lock.unLock()
            }

        }


    }


}

//package com.fty1.center.example.lock;
//
//import com.fty1.lock.Fty1LockFactory;
//import com.fty1.lock.provider.Fty1CacheLock;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.TimeUnit;
//
//@Component
//@Slf4j
//public class CacheLockService {
//
//
//    //@Autowired
//    private Fty1LockFactory fty1LockFactory;
//
//
//    @Async
//    public void test() {
//
//        String key = "LOCK.2019121201317";
//        log.info(key);
//        Fty1CacheLock lock = fty1LockFactory.buildFty1CacheLock();
//        if (lock.tryLock(key,1, TimeUnit.SECONDS)) {
//            log.info("执行业务");
//            try {
//                Thread.sleep(2000);
//                log.info("BEFORE" + key);
//            } catch (Exception e) {
//                log.error("程序错误", e);
//            } finally {
//                lock.unLock();
//            }
//        }
//    }
//
//
//}

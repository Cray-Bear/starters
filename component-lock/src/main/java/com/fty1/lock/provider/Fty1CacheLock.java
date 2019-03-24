package com.fty1.lock.provider;

import com.fty1.lock.Fty1Lock;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Fty1CacheLock implements Fty1Lock {


    private static final int DEFAULT_SINGLE_EXPIRE_TIME = 5;


    private RedissonClient redissonClient;

    private String key;

    private RLock lock;


    public Fty1CacheLock(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }


    private boolean _lock(@NonNull String key, long timeout, @NonNull TimeUnit unit) {
        lock = redissonClient.getLock(key);
        try {
            return lock.tryLock(0,timeout, unit);
        } catch (Exception e) {
           // log.info("_lock error", e);
            return false;
        }
    }

    private void _unlock(String key) {
        try {
            if(lock.isHeldByCurrentThread()){
                this.lock.unlock();
            }
        } catch (Exception e) {
           // log.info("_lock error", e);
        }
    }

    /**
     * 默认3秒过期
     *
     * @param key
     * @return
     */
    public boolean tryLock(@NonNull String key) {
        return tryLock(key, DEFAULT_SINGLE_EXPIRE_TIME, TimeUnit.SECONDS);
    }


    /**
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public boolean tryLock(@NonNull String key, long timeout, @NonNull TimeUnit unit) {
        try {
            boolean res = this._lock(key, timeout, unit);
            if (res) {
                this.key = key;
                log.info("加锁成功");
            }
            return res;
        } catch (Exception e) {
            //log.info("加锁失败", e);
            log.info("加锁失败");
            //unLock(key);
        }

        return false;
    }


    /**
     * @return
     */
    @Override
    public void unLock() {
        this._unlock(this.key);
    }
}

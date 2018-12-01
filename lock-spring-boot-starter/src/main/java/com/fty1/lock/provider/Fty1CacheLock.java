package com.fty1.lock.provider;

import com.fty1.common.date.Fty1DateUtils;
import com.fty1.lock.Fty1Lock;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Fty1CacheLock implements Fty1Lock {

    private static final int DEFAULT_SINGLE_EXPIRE_TIME = 3;


    private StringRedisTemplate redisTemplate;


    public Fty1CacheLock(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private Fty1CacheLock() {

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
        long time = Fty1DateUtils.toSeconds(timeout, unit);
        try {
            return redisTemplate.execute(connection -> connection.setEx(key.getBytes(),time,key.getBytes()), true);
        } catch (Exception e) {
            log.info("加锁失败",e);
            return unLock(key);
        }
    }


    /**
     * @param lock
     * @param expireTime(millisecond)
     * @return
     */
    public boolean tryLock(@NonNull String lock, long expireTime) {


//            log.info("尝试获取锁-key:{}-expireTime:{}", lock, expireTime);
//
//        RedisCallback<Boolean> redisCallback = connection -> connection.setEx(lock.getBytes(), expireTime, lock.getBytes());
//        //return redisTemplate.execute(redisCallback);
//        redisTemplate.expire()
        return tryLock(lock,expireTime,TimeUnit.SECONDS);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public boolean unLock(String key) {
        log.info("尝试删除锁-key:{}", key);
//        if (redisTemplate.delete(key)) {
//            return true;
//        }
//
//        log.info("尝试删除锁-失败-key:{}", key);
//        while (redisTemplate.hasKey(key)) {
//            log.info("尝试删除锁-失败-存在锁-key:{}", key);
//            //保证一定删除掉
//            unLock(key);
//        }
        return redisTemplate.delete(key);
    }
}

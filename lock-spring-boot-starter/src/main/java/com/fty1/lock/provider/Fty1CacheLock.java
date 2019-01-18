package com.fty1.lock.provider;

import com.fty1.common.date.Fty1DateUtils;
import com.fty1.lock.Fty1Lock;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Fty1CacheLock implements Fty1Lock {

    private static final int DEFAULT_SINGLE_EXPIRE_TIME = 3;


    private StringRedisTemplate redisTemplate;


    private String  key;

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
            boolean res = redisTemplate.execute(connection -> connection.setEx(key.getBytes(), time, key.getBytes()), true);
            if (res) {

                this.key = key;

                log.info("加锁成功");
            }
            return res;
        } catch (Exception e) {
            log.info("加锁失败", e);
            //log.info("加锁失败");
            //unLock(key);
        }

        return false;
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
        return tryLock(lock, expireTime, TimeUnit.SECONDS);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public void unLock() {
        log.info("尝试删除锁-key:{}", this.key);
        if(!StringUtils.isEmpty(key)){
            redisTemplate.delete(key);
        }
    }
}

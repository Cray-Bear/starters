package com.fty1.lock.provider;

import com.fty1.common.date.Fty1DateUtils;
import com.fty1.lock.Fty1Lock;
import lombok.NonNull;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
     * @param key
     * @return
     */
    public boolean tryLock(@NonNull String key) {
        return tryLock(key, DEFAULT_SINGLE_EXPIRE_TIME,TimeUnit.SECONDS);
    }


    /**
     *
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public boolean tryLock(@NonNull String key, long timeout, @NonNull TimeUnit unit) {
        long time = Fty1DateUtils.toMilliSeconds(timeout, unit);
        return tryLock(key, time);
    }


    /**
     * @param lock
     * @param expireTime(millisecond)
     * @return
     */
    public boolean tryLock(@NonNull String lock, long expireTime) {
        return (Boolean) redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            long expireAt = System.currentTimeMillis() + expireTime + 1;
            Boolean acquire = connection.setNX(lock.getBytes(), String.valueOf(expireAt).getBytes());
            if (acquire) {
                return true;
            } else {
                byte[] value = connection.get(lock.getBytes());
                if (Objects.nonNull(value) && value.length > 0) {
                    long expireTimeT = Long.parseLong(new String(value));
                    if (expireTimeT < System.currentTimeMillis()) {
                        byte[] oldValue = connection.getSet(lock.getBytes(), String.valueOf(System.currentTimeMillis() + expireTime + 1).getBytes());
                        return Long.parseLong(new String(oldValue)) < System.currentTimeMillis();
                    }
                }
            }
            return false;
        });
    }

    /**
     * @param key
     * @return
     */
    @Override
    public boolean unLock(String key) {
        return  redisTemplate.delete(key);
    }
}

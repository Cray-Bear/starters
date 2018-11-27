package com.fty1.lock;

import com.fty1.lock.provider.Fty1CacheLock;
import org.springframework.data.redis.core.StringRedisTemplate;

public class Fty1LockFactory {


    private StringRedisTemplate stringRedisTemplate;

    public Fty1LockFactory(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }


    public Fty1CacheLock buildFty1CacheLock() {
        return new Fty1CacheLock(stringRedisTemplate);
    }

}

package com.fty1.lock;

import com.fty1.lock.provider.Fty1CacheLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Fty1LockFactory {


    @Autowired
    private RedissonClient redissonClient;

    public Fty1LockFactory(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }


    public Fty1CacheLock buildFty1CacheLock() {
        return new Fty1CacheLock(redissonClient);
    }

}

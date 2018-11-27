package com.fty1.lock;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@ConditionalOnClass(Fty1LockFactory.class)
@EnableConfigurationProperties(RedisProperties.class)
public class Fty1LockAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Fty1LockFactory getFty1LockFactory(StringRedisTemplate stringRedisTemplate) {
        Fty1LockFactory lockFactory = new Fty1LockFactory(stringRedisTemplate);
        return lockFactory;
    }
}

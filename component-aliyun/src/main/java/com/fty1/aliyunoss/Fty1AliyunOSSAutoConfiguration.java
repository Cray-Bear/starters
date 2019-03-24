package com.fty1.aliyunoss;


import com.fty1.aliyunoss.oss.OSSClientFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@ConditionalOnClass(Fty1AliyunOSSService.class)
@EnableConfigurationProperties(Fty1AliyunOSSProperties.class)
public class Fty1AliyunOSSAutoConfiguration {


    @Resource
    private Fty1AliyunOSSProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public Fty1AliyunOSSService getFty1AliyunOSSService() {
        OSSClientFactory ossClientFactory = new OSSClientFactory(properties);
        Fty1AliyunOSSService fty1AliyunOSSService = new Fty1AliyunOSSService(ossClientFactory.getOSSClient());
        return fty1AliyunOSSService;
    }
}

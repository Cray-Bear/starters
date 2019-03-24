package com.fty1.example;

import com.fty1.example.config.Fty1ExampleProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@ConditionalOnClass(Fty1ExampleService.class)
@EnableConfigurationProperties(Fty1ExampleProperties.class)
public class Fty1ExampleAutoConfiguration {


    @Resource
    private Fty1ExampleProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public Fty1ExampleService getFty1ExampleService() {
        Fty1ExampleService fty1ExampleService = new Fty1ExampleService();
        fty1ExampleService.setProperties(properties);
        return fty1ExampleService;
    }
}

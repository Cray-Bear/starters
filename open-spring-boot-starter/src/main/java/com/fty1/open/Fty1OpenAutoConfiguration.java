package com.fty1.open;


import com.fty1.open.config.Fty1OpenProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@ConditionalOnClass(Fty1OpenService.class)
@EnableConfigurationProperties(Fty1OpenProperties.class)
public class Fty1OpenAutoConfiguration {


    @Resource
    private Fty1OpenProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public Fty1OpenService getFty1OpenService() {
        Fty1OpenService fty1OpenService = new Fty1OpenService();
        String url = properties.getUrl();
        fty1OpenService.setUrl(url);
        return fty1OpenService;
    }
}

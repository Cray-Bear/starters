package com.fty1.component.task.config;


import com.fty1.component.task.facade.Fty1TaskFacade;
import com.fty1.component.task.facade.impl.Fty1TaskFacadeImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
@ConditionalOnClass(value = {Fty1TaskFacade.class, DataSource.class})
@EnableConfigurationProperties(Fty1TaskProperties.class)
@Slf4j
public class Fty1TaskAutoConfiguration {


    @Autowired
    private Fty1TaskProperties properties;


    @Autowired
    private EntityManager entityManager;

    @Autowired
    private DataSource dataSource;

    @Bean
    @ConditionalOnMissingBean
    public Fty1TaskFacade getFty1TaskFacade() {
        log.info("fty1.task.off={}",properties.isOff());
        log.info("fty1.task.off={}",dataSource.hashCode());
        return new Fty1TaskFacadeImpl();
    }
}

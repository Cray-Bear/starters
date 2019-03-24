package com.fty1.open.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fty1.open")
@Data
public class Fty1OpenProperties {
    private String url = "http://www.baidu.com/";
}

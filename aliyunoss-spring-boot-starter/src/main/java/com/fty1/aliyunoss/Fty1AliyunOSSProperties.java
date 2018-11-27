package com.fty1.aliyunoss;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fty1.open")
@Data
public class Fty1AliyunOSSProperties {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
}

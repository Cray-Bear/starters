package com.fty1.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fty1.example")
@Data
public class Fty1ExampleProperties {
    private String name = "Hello World!";
}

package com.fty1.component.task.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fty1.task")
@Data
public class Fty1TaskProperties {
    private boolean off;
}

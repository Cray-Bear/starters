package com.fty1.center.mock.ip;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IPSchedule {

    @Scheduled(fixedDelay = 1000)
    public void ipBuild() {
        log.info("IP:"+System.currentTimeMillis());
    }
}

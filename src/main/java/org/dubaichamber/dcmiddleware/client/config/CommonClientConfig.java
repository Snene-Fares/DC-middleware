package org.dubaichamber.dcmiddleware.client.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class CommonClientConfig {

    @Bean
    public Logger.Level feignLoggerK() {
        return Logger.Level.FULL;
    }
}

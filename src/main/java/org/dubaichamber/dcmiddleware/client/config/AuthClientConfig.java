package org.dubaichamber.dcmiddleware.client.config;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AuthClientConfig {

    @Bean
    public ErrorDecoder errorDecoder(){
        return new AuthFeignErrorDecoder();
    }
}

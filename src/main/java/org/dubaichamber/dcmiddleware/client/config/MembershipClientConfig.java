package org.dubaichamber.dcmiddleware.client.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class MembershipClientConfig {
    @Value("${rest-ws.membership-services.sso-user}")
    private String siebelUser;

    @Bean
    public RequestInterceptor membershipInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            requestTemplate.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            requestTemplate.header("SSO_SIEBEL_USER", siebelUser);
        };
    }
}

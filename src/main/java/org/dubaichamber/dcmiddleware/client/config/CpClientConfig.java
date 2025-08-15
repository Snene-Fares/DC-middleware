package org.dubaichamber.dcmiddleware.client.config;

import feign.RequestInterceptor;
import org.dubaichamber.dcmiddleware.util.CommonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class CpClientConfig {
    @Value("${rest-ws.cp-services.headers.basic-auth.username}")
    private String username;
    @Value("${rest-ws.cp-services.headers.basic-auth.password}")
    private String password;
    @Value("${rest-ws.cp-services.headers.siebel-user}")
    private String siebelUser;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            requestTemplate.header(HttpHeaders.AUTHORIZATION, CommonUtils.getBasicAuthorizationHeader(username, password));
            requestTemplate.header("access_token", CommonUtils.getBasicAuthorizationHeader(username, password));
            requestTemplate.header("SSO_SIEBEL_USER", siebelUser);
        };
    }
}

package org.dubaichamber.dcmiddleware.client.config;

import feign.Client;
import feign.RequestInterceptor;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.dubaichamber.dcmiddleware.util.CommonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class SCIMUserManagementClientConfig {
    @Value("${rest-ws.scim-user-management.basic-auth.username}")
    private String username;
    @Value("${rest-ws.scim-user-management.basic-auth.password}")
    private String password;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            requestTemplate.header(HttpHeaders.AUTHORIZATION, CommonUtils.getBasicAuthorizationHeader(username, password));
        };
    }

    @Bean
    public Client feignClient() {
        return new ApacheHttpClient(HttpClients.createDefault());
    }
}

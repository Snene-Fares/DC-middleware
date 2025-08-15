package org.dubaichamber.dcmiddleware.client;

import org.dubaichamber.dcmiddleware.client.config.CommonClientConfig;
import org.dubaichamber.dcmiddleware.client.config.UserRegistrationClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-registration-client", url = "${rest-ws.user-registration.base-url}" ,
        configuration = {CommonClientConfig.class, UserRegistrationClientConfig.class }
)
public interface UserRegistrationClient {

    @PostMapping("${rest-ws.user-registration.self-register.url}")
    Object registerUser(@RequestBody Object requestDTO);
}

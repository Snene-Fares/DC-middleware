package org.dubaichamber.dcmiddleware.client;


import org.dubaichamber.dcmiddleware.client.config.CommonClientConfig;
import org.dubaichamber.dcmiddleware.client.config.MembershipClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "membership-client", url = "${rest-ws.scim-user-management.base-url}" ,
        configuration = {CommonClientConfig.class , MembershipClientConfig.class}
)
public interface MembershipClient {

    @PostMapping("${rest-ws.membership-services.user-profile-detail.url}")
    Object userProfileDetails(@RequestBody Object request);
}

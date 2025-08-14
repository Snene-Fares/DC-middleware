package org.dubaichamber.dcmiddleware.client;

import org.dubaichamber.dcmiddleware.client.config.CommonClientConfig;
import org.dubaichamber.dcmiddleware.client.config.SCIMUserManagementConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-management-client", url = "${rest-ws.scim-user-management.base-url}" ,
        configuration = {CommonClientConfig.class , SCIMUserManagementConfig.class}
)
public interface SCIMUserManagementClient {

    void getUser(@RequestParam("filter") String filter);
}

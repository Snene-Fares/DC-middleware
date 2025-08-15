package org.dubaichamber.dcmiddleware.client;

import org.dubaichamber.dcmiddleware.client.config.CommonClientConfig;
import org.dubaichamber.dcmiddleware.client.config.SCIMUserManagementClientConfig;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.ScimUserListWsResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-management-client", url = "${rest-ws.scim-user-management.base-url}" ,
        configuration = {CommonClientConfig.class , SCIMUserManagementClientConfig.class}
)
public interface SCIMUserManagementClient {

    @GetMapping("${rest-ws.scim-user-management.get-user.url}")
    ScimUserListWsResponseDTO getUser(@RequestParam("filter") String filter);

    @PatchMapping("${rest-ws.scim-user-management.update-user.url}")
    void updateUser(@PathVariable String uuid, @RequestBody Object requestDTO);
}

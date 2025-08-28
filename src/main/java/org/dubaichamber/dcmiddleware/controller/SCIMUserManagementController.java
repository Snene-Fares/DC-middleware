package org.dubaichamber.dcmiddleware.controller;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.ScimUserListWsResponseDTO;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.SimpleUserResponseDTO;
import org.dubaichamber.dcmiddleware.service.SCIMUserManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scim-user-management")
@RequiredArgsConstructor
public class SCIMUserManagementController {
    private final SCIMUserManagementService scimUserManagementService;

    @GetMapping
    public ResponseEntity<SimpleUserResponseDTO> getUser(@RequestParam String userName) {
        return ResponseEntity.ok(scimUserManagementService.getUser(userName));
    }

    @PostMapping("/reset-passwrod/{uuid}")
    public ResponseEntity<Void> resetPassword(@PathVariable String uuid, @RequestParam String newPassword) {
        scimUserManagementService.resetPassword(uuid, newPassword);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/update-user/{uuid}")
    public ResponseEntity<Void> updateUser(@PathVariable String uuid, @RequestBody Object request) {
        scimUserManagementService.updateUser(uuid, request);
        return ResponseEntity.noContent().build();
    }

}

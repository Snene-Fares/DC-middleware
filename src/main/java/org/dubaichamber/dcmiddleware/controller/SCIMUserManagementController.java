package org.dubaichamber.dcmiddleware.controller;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.ScimUserListWsResponseDTO;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.SimpleUserResponseDTO;
import org.dubaichamber.dcmiddleware.service.SCIMUserManagementService;
import org.dubaichamber.dcmiddleware.util.SecurityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scim-user-management")
@RequiredArgsConstructor
public class SCIMUserManagementController {
    private final SCIMUserManagementService scimUserManagementService;

    @GetMapping
    public ResponseEntity<SimpleUserResponseDTO> getUser() {
        return ResponseEntity.ok(scimUserManagementService.getUser());
    }

    @PostMapping("/reset-passwrod")
    public ResponseEntity<Void> resetPassword(@RequestParam String newPassword) {
        scimUserManagementService.resetPassword(newPassword);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/update-user")
    public ResponseEntity<Object> updateUser(@RequestBody Object request) {
        scimUserManagementService.updateUser(request);
        return ResponseEntity.noContent().build();
    }

}

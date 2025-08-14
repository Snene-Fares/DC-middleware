package org.dubaichamber.dcmiddleware.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scim-user-management")
@RequiredArgsConstructor
public class SCIMUserManagementController {

    @GetMapping
    public ResponseEntity<Void> getUser() {
        return null;
    }
}

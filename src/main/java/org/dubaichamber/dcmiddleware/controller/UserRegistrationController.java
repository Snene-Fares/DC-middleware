package org.dubaichamber.dcmiddleware.controller;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.dto.userregistration.SimpleUserRegistrationRequestDTO;
import org.dubaichamber.dcmiddleware.dto.userregistration.UserRegistrationRequestDTO;
import org.dubaichamber.dcmiddleware.service.UserRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-registration")
@RequiredArgsConstructor
public class UserRegistrationController {
    private final UserRegistrationService userRegistrationService;

    @PostMapping
    public ResponseEntity<Object> registerUser(@RequestBody SimpleUserRegistrationRequestDTO request) {
        Object response = userRegistrationService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}

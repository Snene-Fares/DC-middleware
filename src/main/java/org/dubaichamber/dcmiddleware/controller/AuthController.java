package org.dubaichamber.dcmiddleware.controller;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.dto.LoginRequestDTO;
import org.dubaichamber.dcmiddleware.dto.TokenWsResponseDTO;
import org.dubaichamber.dcmiddleware.service.impl.OAuth2ServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthController {
    private final OAuth2ServiceImpl oauth2ServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<TokenWsResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        TokenWsResponseDTO response = oauth2ServiceImpl.authenticate(loginRequestDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> logout(@RequestHeader(AUTHORIZATION) String token) {
        oauth2ServiceImpl.logout(token);
        return ResponseEntity.ok().build();
    }
}

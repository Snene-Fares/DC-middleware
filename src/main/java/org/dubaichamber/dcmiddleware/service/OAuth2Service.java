package org.dubaichamber.dcmiddleware.service;

import org.dubaichamber.dcmiddleware.dto.auth.LoginRequestDTO;
import org.dubaichamber.dcmiddleware.dto.auth.TokenWsResponseDTO;

public interface OAuth2Service {
    TokenWsResponseDTO authenticate(LoginRequestDTO authRequest);
    void logout(String token);
}

package org.dubaichamber.dcmiddleware.service;

import org.dubaichamber.dcmiddleware.dto.LoginRequestDTO;
import org.dubaichamber.dcmiddleware.dto.TokenWsResponseDTO;

public interface OAuth2Service {
    TokenWsResponseDTO authenticate(LoginRequestDTO authRequest);
    void logout(String token);
}

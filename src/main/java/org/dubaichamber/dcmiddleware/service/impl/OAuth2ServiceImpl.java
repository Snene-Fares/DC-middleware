package org.dubaichamber.dcmiddleware.service.impl;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.client.AuthClient;
import org.dubaichamber.dcmiddleware.dto.auth.AuthenticateResponseWsDTO;
import org.dubaichamber.dcmiddleware.dto.auth.AuthorizeResponseWsDTO;
import org.dubaichamber.dcmiddleware.dto.auth.LoginRequestDTO;
import org.dubaichamber.dcmiddleware.dto.auth.TokenWsResponseDTO;
import org.dubaichamber.dcmiddleware.mapper.OAuth2Mapper;
import org.dubaichamber.dcmiddleware.service.OAuth2Service;
import org.dubaichamber.dcmiddleware.util.PkceUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OAuth2ServiceImpl implements OAuth2Service {
    private final AuthClient oAuthClient;
    private final PkceUtil pkceUtil;
    private final OAuth2Mapper oAuth2Mapper;

    @Value("${oauth2.client.id}")
    private String clientId;

    @Value("${oauth2.client.redirect-uri}")
    private String redirectUri;

    @Value("${oauth2.client.scope}")
    private String scope;


    public TokenWsResponseDTO authenticate(LoginRequestDTO authRequest) {
            // Step 1: Generate PKCE code verifier and challenge
            String codeVerifier = pkceUtil.generateCodeVerifier();
            String codeChallenge = pkceUtil.generateCodeChallenge(codeVerifier);

            // Step 2: Initiate authorization request
            AuthorizeResponseWsDTO authResponse = oAuthClient.authorize(
                    clientId,
                    "code",
                    redirectUri,
                    scope,
                    "direct",
                    "S256",
                    codeChallenge,
                    "logpg"
            );

            // Step 3: Authenticate user (Username , Password)
            AuthenticateResponseWsDTO authenticate = oAuthClient.authenticate(oAuth2Mapper.mapRequest(authRequest,authResponse));

            // Step 4: Generate User Token
            return oAuthClient.getToken(
                    clientId,
                    authenticate.getAuthData().getCode(),
                    "authorization_code",
                    redirectUri,
                    codeVerifier
            );

    }

    public void logout(String token) {
        oAuthClient.logout(token,"direct");
    }
}

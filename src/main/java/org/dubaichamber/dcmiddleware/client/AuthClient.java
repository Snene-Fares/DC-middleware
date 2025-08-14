package org.dubaichamber.dcmiddleware.client;

import org.dubaichamber.dcmiddleware.client.config.CommonClientConfig;
import org.dubaichamber.dcmiddleware.dto.AuthenticateRequestWsDTO;
import org.dubaichamber.dcmiddleware.dto.AuthenticateResponseWsDTO;
import org.dubaichamber.dcmiddleware.dto.AuthorizeResponseWsDTO;
import org.dubaichamber.dcmiddleware.dto.TokenWsResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth-client", url = "${oauth2.provider.base-url}" ,
        configuration = {CommonClientConfig.class, }
)
public interface AuthClient {

    @PostMapping(value = "${oauth2.provider.authorize}",
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json")
    AuthorizeResponseWsDTO authorize(
            @RequestParam("client_id") String clientId,
            @RequestParam("response_type") String responseType,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("scope") String scope,
            @RequestParam("response_mode") String responseMode,
            @RequestParam("code_challenge_method") String codeChallengeMethod,
            @RequestParam("code_challenge") String codeChallenge,
            @RequestParam("state") String state
    );

    @PostMapping(value = "${oauth2.provider.authn}",
            produces = "application/json")
    AuthenticateResponseWsDTO authenticate(@RequestBody AuthenticateRequestWsDTO authenticateRequest);

    @PostMapping(value = "${oauth2.provider.token}",
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json")
    TokenWsResponseDTO getToken(
            @RequestParam("client_id") String clientId,
            @RequestParam("code") String code,
            @RequestParam("grant_type") String grantType,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("code_verifier") String codeVerifier
    );

    @PostMapping(value = "${oauth2.provider.logout}",
            consumes = "application/x-www-form-urlencoded")
    Void logout(
            @RequestParam("id_token_hint") String idTokenHint,
            @RequestParam("response_mode") String responseMode
    );

}
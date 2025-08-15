package org.dubaichamber.dcmiddleware.mapper;

import org.dubaichamber.dcmiddleware.dto.auth.AuthenticateRequestWsDTO;
import org.dubaichamber.dcmiddleware.dto.auth.AuthorizeResponseWsDTO;
import org.dubaichamber.dcmiddleware.dto.auth.LoginRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface OAuth2Mapper {
    String USERNAME_PASSWORD = "Username & Password";

    @Mapping(source = "authResponse.flowId", target = "flowId")
    @Mapping(source = "authResponse.nextStep.authenticators", target = "selectedAuthenticator.authenticatorId" , qualifiedByName = "mapAuthenticatorId")
    @Mapping(source = "authRequest.username", target = "selectedAuthenticator.params.username")
    @Mapping(source = "authRequest.password", target = "selectedAuthenticator.params.password")
    AuthenticateRequestWsDTO mapRequest(LoginRequestDTO authRequest, AuthorizeResponseWsDTO authResponse);

    @Named("mapAuthenticatorId")
    default String mapAuthenticatorId(List<AuthorizeResponseWsDTO.Authenticator> authenticatorList) {
        return Optional.ofNullable(authenticatorList)
                .orElseGet(Collections::emptyList)
                .stream()
                        .filter(authenticator -> authenticator != null && USERNAME_PASSWORD.equals(authenticator.getAuthenticator()))
                        .map(AuthorizeResponseWsDTO.Authenticator::getAuthenticatorId)
                .findFirst()
                .orElse(null);
    }
}

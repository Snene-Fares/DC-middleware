package org.dubaichamber.dcmiddleware.mapper;

import org.dubaichamber.dcmiddleware.dto.userregistration.SimpleUserRegistrationRequestDTO;
import org.dubaichamber.dcmiddleware.dto.userregistration.UserRegistrationRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRegistrationMapper {
    @Mapping(source = "username", target = "user.username")
    @Mapping(source = "password", target = "user.password")
    @Mapping(target = "user.realm", constant = "primary")
    @Mapping(source = ".", target = "user.claims", qualifiedByName = "mapClaims")
    UserRegistrationRequestDTO toMiddlewareRequest(SimpleUserRegistrationRequestDTO dto);

    @Named("mapClaims")
    default List<UserRegistrationRequestDTO.ClaimDTO> mapClaims(SimpleUserRegistrationRequestDTO dto) {
        List<UserRegistrationRequestDTO.ClaimDTO> claims = new ArrayList<>();
        claims.add(buildClaim("http://wso2.org/claims/emailaddress", dto.getEmail()));
        claims.add(buildClaim("http://wso2.org/claims/givenname", dto.getFirstName()));
        claims.add(buildClaim("http://wso2.org/claims/lastname", dto.getLastName()));
        claims.add(buildClaim("http://wso2.org/claims/country", dto.getCountry()));
        claims.add(buildClaim("http://wso2.org/claims/mobile", dto.getMobile()));
        claims.add(buildClaim("http://wso2.org/claims/title", dto.getTitle()));
        claims.add(buildClaim("http://wso2.org/claims/emiratesId", dto.getEmiratesId()));
        claims.add(buildClaim("http://wso2.org/claims/passport", dto.getPassport()));
        return claims;
    }

    private UserRegistrationRequestDTO.ClaimDTO buildClaim(String uri, String value) {
        UserRegistrationRequestDTO.ClaimDTO claim = new UserRegistrationRequestDTO.ClaimDTO();
        claim.setUri(uri);
        claim.setValue(value);
        return claim;
    }
}

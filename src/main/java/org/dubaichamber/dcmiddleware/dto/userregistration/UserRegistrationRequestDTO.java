package org.dubaichamber.dcmiddleware.dto.userregistration;

import lombok.Data;

import java.util.List;

@Data
public class UserRegistrationRequestDTO {
    private UserDTO user;

    @Data
    public static class UserDTO {
        private String username;
        private String realm;
        private String password;
        private List<ClaimDTO> claims;
    }

    @Data
    public static class ClaimDTO {
        private String uri;
        private String value;
    }
}

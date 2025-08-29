package org.dubaichamber.dcmiddleware.dto.userregistration;

import lombok.Data;

@Data
public class SimpleUserRegistrationRequestDTO {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String mobile;
    private String country;
    private String title;
    private String emiratesId;
    private String passport;
}

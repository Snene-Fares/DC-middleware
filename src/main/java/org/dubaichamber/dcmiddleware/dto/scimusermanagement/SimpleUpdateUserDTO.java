package org.dubaichamber.dcmiddleware.dto.scimusermanagement;

import lombok.Data;

@Data
public class SimpleUpdateUserDTO {
    private String userName;
    private String givenName;
    private String familyName;
    private String country;
    private String email;
    private String phoneNumber;
    private String title;
    private String emiratesId;
}

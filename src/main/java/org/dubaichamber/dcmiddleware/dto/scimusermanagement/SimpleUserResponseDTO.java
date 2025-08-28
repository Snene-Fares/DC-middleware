package org.dubaichamber.dcmiddleware.dto.scimusermanagement;

import lombok.Data;

@Data
public class SimpleUserResponseDTO {
    private String id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String country;
    private String title;
}

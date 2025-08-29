package org.dubaichamber.dcmiddleware.dto.dcipublic;

import lombok.Data;

@Data
public class ContactUsRequestDto {
    private String name;
    private String email;
    private String mobile;
    private String message;
}

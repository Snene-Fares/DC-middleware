package org.dubaichamber.dcmiddleware.dto.dcipublic;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class ContactUsResponseDto {
    private Long id;
    private String name;
    private String email;
    private String mobile;
    private String message;
    private String externalReferenceCode;
    private Creator creator;
    private ZonedDateTime dateCreated;
    private ZonedDateTime dateModified;
    private Status status;
    private List<String> keywords;
    private List<Object> taxonomyCategoryBriefs;

    @Data
    public static class Creator {
        private String additionalName;
        private String contentType;
        private String familyName;
        private String givenName;
        private Long id;
        private String name;
    }

    @Data
    public static class Status {
        private int code;
        private String label;
        private String label_i18n;
    }
}


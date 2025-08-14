package org.dubaichamber.dcmiddleware.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthClient400Exception {
    private String code;
    private String message;
    private String description;
}

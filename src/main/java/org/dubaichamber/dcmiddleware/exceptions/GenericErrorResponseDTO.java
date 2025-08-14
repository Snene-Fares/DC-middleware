package org.dubaichamber.dcmiddleware.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenericErrorResponseDTO {
    private String errorCode;
    private String errorDescription;
    private String errorDetails;
}

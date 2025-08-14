package org.dubaichamber.dcmiddleware.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericException extends RuntimeException{
    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorDescription;

    public GenericException(HttpStatus httpStatus, String errorCode, String errorDescription) {
        super(errorDescription);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
}

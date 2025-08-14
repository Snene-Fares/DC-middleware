package org.dubaichamber.dcmiddleware.exceptions;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;


@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<GenericErrorResponseDTO> handleGenericExceptions(GenericException ex){
        log.error("GenericException :", ex);
        GenericErrorResponseDTO genericErrorResponseDTO = GenericErrorResponseDTO.builder()
                .errorCode(ex.getErrorCode())
                .errorDescription(ex.getErrorDescription())
                .errorDetails(ex.getMessage())
                .build();
        return ResponseEntity.status(400).body(genericErrorResponseDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericErrorResponseDTO> handleExceptions(Exception ex){
        log.error("Exception :", ex);
        GenericErrorResponseDTO genericErrorResponseDTO = GenericErrorResponseDTO.builder()
                .errorCode("INTERNAL_SERVER_ERROR")
                .errorDescription("Internal Server Error")
                .errorDetails(ex.getMessage())
                .build();
        return ResponseEntity.status(500).body(genericErrorResponseDTO);
    }

}

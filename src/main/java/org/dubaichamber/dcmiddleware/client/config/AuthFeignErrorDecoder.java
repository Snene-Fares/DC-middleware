package org.dubaichamber.dcmiddleware.client.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.dubaichamber.dcmiddleware.exceptions.AuthClient400Exception;
import org.dubaichamber.dcmiddleware.exceptions.GenericException;
import org.springframework.http.HttpStatus;

import java.io.IOException;

public class AuthFeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return handleFeignException(methodKey, mapper, response);
        } catch (Exception ex) {
            return new Exception(ex.getMessage());
        }
    }

    private Exception handleFeignException(String methodKey, ObjectMapper mapper, Response response) throws IOException {
        switch (response.status()) {
            case 400:
                AuthClient400Exception authClient400Exception = mapper.readValue(response.body().asInputStream(), AuthClient400Exception.class);
                return new GenericException(HttpStatus.valueOf(response.status()), authClient400Exception.getCode(), authClient400Exception.getMessage());
            default:
                return new RuntimeException(response.reason());
        }
    }
}

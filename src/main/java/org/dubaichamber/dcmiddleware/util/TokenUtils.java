package org.dubaichamber.dcmiddleware.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.dubaichamber.dcmiddleware.exceptions.GenericErrorResponseDTO;
import org.dubaichamber.dcmiddleware.exceptions.GenericException;
import org.springframework.http.HttpStatus;

public class TokenUtils {

    public static Claims decodeWithoutVerification(String token) {
        if (token.contains("Bearer "))
            token = token.substring(7);
        int i = token.lastIndexOf('.');
        String withoutSignature = token.substring(0, i+1);
        return Jwts.parser().parseClaimsJwt(withoutSignature).getBody();
    }
}

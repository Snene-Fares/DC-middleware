package org.dubaichamber.dcmiddleware.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.exceptions.GenericErrorResponseDTO;
import org.dubaichamber.dcmiddleware.exceptions.GenericException;
import org.dubaichamber.dcmiddleware.util.TokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String errorCode;
        String message;
        if (request.getHeaders(AUTHORIZATION).hasMoreElements()) {
            try {
                String userId = TokenUtils.decodeWithoutVerification(request.getHeaders(AUTHORIZATION).nextElement()).get("sub").toString();
                request.setAttribute("userId", userId);
            } catch (Exception ex) {
            if (ex instanceof ExpiredJwtException) {
                errorCode = "TOKEN_EXPIRED";
                message = "Authentication token has expired";
            } else if (ex instanceof UnsupportedJwtException) {
                errorCode = "TOKEN_UNSUPPORTED";
                message = "Token format not supported";
            } else if (ex instanceof MalformedJwtException) {
                errorCode = "TOKEN_MALFORMED";
                message = "Token is malformed";
            } else if (ex instanceof SignatureException) {
                errorCode = "TOKEN_SIGNATURE_INVALID";
                message = "Token signature validation failed";
            } else if (ex instanceof IllegalArgumentException) {
                errorCode = "TOKEN_MISSING";
                message = "Authorization header is missing or invalid";
            } else {
                errorCode = "AUTHENTICATION_FAILED";
                message = "Authentication failed";
            }
                GenericErrorResponseDTO errorResponseDTO = GenericErrorResponseDTO.builder()
                        .errorCode(errorCode)
                        .errorDescription(message)
                        .build();

                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write(objectMapper.writeValueAsString(errorResponseDTO));
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}

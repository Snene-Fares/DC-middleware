package org.dubaichamber.dcmiddleware.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AppAuthenticationManager implements AuthenticationManager {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String principal = (String) authentication.getPrincipal();

        if(StringUtils.isNotEmpty(principal)) {
            authentication.setAuthenticated(true);
        }

        return authentication;
    }
}
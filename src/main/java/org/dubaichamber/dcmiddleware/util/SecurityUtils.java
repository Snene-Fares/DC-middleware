package org.dubaichamber.dcmiddleware.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SecurityUtils {

    public static String getAuthenticatedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken))
            return (String) authentication.getPrincipal();
        else
            return null;
    }
}

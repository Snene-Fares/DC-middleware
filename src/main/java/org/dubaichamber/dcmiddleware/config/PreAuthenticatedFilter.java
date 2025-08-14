package org.dubaichamber.dcmiddleware.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@Slf4j
public class PreAuthenticatedFilter extends AbstractPreAuthenticatedProcessingFilter {
    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        log.debug("Loggin User Id Header: = {}" , request.getAttribute("userId"));
        return request.getAttribute("userId");
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "N/A";
    }
}

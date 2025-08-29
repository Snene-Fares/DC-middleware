package org.dubaichamber.dcmiddleware.util;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.client.SCIMUserManagementClient;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.ScimUserListWsResponseDTO;
import org.dubaichamber.dcmiddleware.exceptions.GenericException;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import static org.dubaichamber.dcmiddleware.util.CommonUtils.filterFormatter;

@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
@RequiredArgsConstructor
public class SCIMProfileHolder {
    private final ThreadLocal<ScimUserListWsResponseDTO> principal = new ThreadLocal<>();
    private final SCIMUserManagementClient scimUserManagementClient;

    public ScimUserListWsResponseDTO get() {
        if (principal.get() == null) {
            principal.set(scimUserManagementClient.getUser(filterFormatter(SecurityUtils.getAuthenticatedUserId())));
        }
        return principal.get();
    }

    public String getUUID() {
        return get().getResources().stream()
                .findFirst()
                .orElseThrow(() -> new GenericException(HttpStatus.BAD_REQUEST, "USER_NOT_FOUND", "User not found"))
                .getId();
    }

    public void clear() {
        principal.remove();
    }
}

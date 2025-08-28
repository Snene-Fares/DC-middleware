package org.dubaichamber.dcmiddleware.service;

import org.dubaichamber.dcmiddleware.dto.scimusermanagement.ScimUserListWsResponseDTO;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.SimpleUserResponseDTO;
import org.springframework.http.ResponseEntity;

public interface SCIMUserManagementService {
    SimpleUserResponseDTO getUser(String userName);

    void resetPassword(String uuid, String newPassword);

    void updateUser(String uuid, Object request);
}

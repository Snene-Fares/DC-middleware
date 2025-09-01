package org.dubaichamber.dcmiddleware.service;

import org.dubaichamber.dcmiddleware.dto.scimusermanagement.ScimUserListWsResponseDTO;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.SimpleUserResponseDTO;
import org.springframework.http.ResponseEntity;

public interface SCIMUserManagementService {

    SimpleUserResponseDTO getUser();

    void resetPassword(String newPassword);

    void updateUser(Object request);
}

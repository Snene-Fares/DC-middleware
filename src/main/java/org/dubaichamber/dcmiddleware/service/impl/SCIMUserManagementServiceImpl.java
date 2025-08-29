package org.dubaichamber.dcmiddleware.service.impl;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.client.SCIMUserManagementClient;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.ScimUserListWsResponseDTO;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.SimpleUserResponseDTO;
import org.dubaichamber.dcmiddleware.mapper.SCIMUserManagementMapper;
import org.dubaichamber.dcmiddleware.service.SCIMUserManagementService;
import org.dubaichamber.dcmiddleware.util.SecurityUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SCIMUserManagementServiceImpl implements SCIMUserManagementService {
    private final SCIMUserManagementClient scimUserManagementClient;
    private final SCIMUserManagementMapper scimUserManagementMapper;

    @Override

    public SimpleUserResponseDTO  getUser() {
        ScimUserListWsResponseDTO userResponse = scimUserManagementClient.getUser(
                filterFormatter(SecurityUtils.getAuthenticatedUserId())
        );
        if (userResponse.getResources() != null && !userResponse.getResources().isEmpty()) {
            return scimUserManagementMapper.mapToSimpleUserResponse(userResponse.getResources().get(0));
        }
        return null;
    }

    @Override
    public void resetPassword(String newPassword) {
        SimpleUserResponseDTO user = getUser();
        if (user != null) {
            scimUserManagementClient.updateUser(
                    user.getId(),
                    scimUserManagementMapper.mapRequest(newPassword)
            );
        }
    }

    @Override
    public void updateUser(Object request) {
        SimpleUserResponseDTO user = getUser();
        if (user != null) {
            scimUserManagementClient.updateUser(user.getId(), request);
        }
    }

    private String filterFormatter(String filter) {
        return "userName eq \"" + filter + "\"";
    }
}

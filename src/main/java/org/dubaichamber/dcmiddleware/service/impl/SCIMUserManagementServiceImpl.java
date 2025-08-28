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
    public ScimUserListWsResponseDTO getUser() {
        return scimUserManagementClient.getUser(filterFormatter(SecurityUtils.getAuthenticatedUserId()));
    }

    @Override
    public void resetPassword(String newPassword) {
        ScimUserListWsResponseDTO user = getUser();
        scimUserManagementClient.updateUser(user.getResources().get(1).getId(),scimUserManagementMapper.mapRequest(newPassword));
    }

    @Override
    public void updateUser(Object request) {
        ScimUserListWsResponseDTO user = getUser();
        scimUserManagementClient.updateUser(user.getResources().get(1).getId(),request);
    }

    private String filterFormatter(String filter) {
        return "userName eq \"" + filter + "\"";
    }
}

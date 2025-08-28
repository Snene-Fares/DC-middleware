package org.dubaichamber.dcmiddleware.service.impl;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.client.SCIMUserManagementClient;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.ScimUserListWsResponseDTO;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.SimpleUserResponseDTO;
import org.dubaichamber.dcmiddleware.mapper.SCIMUserManagementMapper;
import org.dubaichamber.dcmiddleware.service.SCIMUserManagementService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SCIMUserManagementServiceImpl implements SCIMUserManagementService {
    private final SCIMUserManagementClient scimUserManagementClient;
    private final SCIMUserManagementMapper scimUserManagementMapper;

    @Override
    public SimpleUserResponseDTO getUser(String userName) {
        ScimUserListWsResponseDTO response = scimUserManagementClient.getUser(filterFormatter(userName));
        if (response.getResources() != null && !response.getResources().isEmpty()) {
            return scimUserManagementMapper.mapToSimpleUserResponse(response.getResources().get(0));
        }
        return null;
    }

    @Override
    public void resetPassword(String uuid, String newPassword) {
        scimUserManagementClient.updateUser(uuid,scimUserManagementMapper.mapRequest(newPassword));
    }

    @Override
    public void updateUser(String uuid, Object request) {
        scimUserManagementClient.updateUser(uuid,request);
    }

    private String filterFormatter(String filter) {
        return "userName eq \"" + filter + "\"";
    }
}

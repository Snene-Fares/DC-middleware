package org.dubaichamber.dcmiddleware.service.impl;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.client.SCIMUserManagementClient;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.ScimUserListWsResponseDTO;
import org.dubaichamber.dcmiddleware.mapper.SCIMUserManagementMapper;
import org.dubaichamber.dcmiddleware.service.SCIMUserManagementService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SCIMUserManagementServiceImpl implements SCIMUserManagementService {
    private final SCIMUserManagementClient scimUserManagementClient;
    private final SCIMUserManagementMapper scimUserManagementMapper;

    @Override
    public ScimUserListWsResponseDTO getUser(String userName) {
        return scimUserManagementClient.getUser(filterFormatter(userName));
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

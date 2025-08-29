package org.dubaichamber.dcmiddleware.service.impl;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.client.SCIMUserManagementClient;
import org.dubaichamber.dcmiddleware.dto.scimusermanagement.ScimUserListWsResponseDTO;
import org.dubaichamber.dcmiddleware.mapper.SCIMUserManagementMapper;
import org.dubaichamber.dcmiddleware.service.SCIMUserManagementService;
import org.dubaichamber.dcmiddleware.util.SCIMProfileHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SCIMUserManagementServiceImpl implements SCIMUserManagementService {
    private final SCIMUserManagementClient scimUserManagementClient;
    private final SCIMUserManagementMapper scimUserManagementMapper;
    private final SCIMProfileHolder scimProfileHolder;

    @Override
    public ScimUserListWsResponseDTO getUser() {
        return scimProfileHolder.get();
    }

    @Override
    public void resetPassword(String newPassword) {
        scimUserManagementClient.updateUser(scimProfileHolder.getUUID(),scimUserManagementMapper.mapRequest(newPassword));
    }

    @Override
    public void updateUser(Object request) {
        scimUserManagementClient.updateUser(scimProfileHolder.getUUID(),request);
    }


}

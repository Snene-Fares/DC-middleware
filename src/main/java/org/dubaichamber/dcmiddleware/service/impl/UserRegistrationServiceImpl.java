package org.dubaichamber.dcmiddleware.service.impl;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.client.UserRegistrationClient;
import org.dubaichamber.dcmiddleware.dto.userregistration.SimpleUserRegistrationRequestDTO;
import org.dubaichamber.dcmiddleware.dto.userregistration.UserRegistrationRequestDTO;
import org.dubaichamber.dcmiddleware.mapper.UserRegistrationMapper;
import org.dubaichamber.dcmiddleware.service.UserRegistrationService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {
    private final UserRegistrationClient userRegistrationClient;
    private final UserRegistrationMapper userRegistrationMapper;



    @Override
    public Object registerUser(SimpleUserRegistrationRequestDTO request) {
        UserRegistrationRequestDTO mappedRequest = userRegistrationMapper.toMiddlewareRequest(request);
        return userRegistrationClient.registerUser(mappedRequest);    }
}

package org.dubaichamber.dcmiddleware.service.impl;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.client.UserRegistrationClient;
import org.dubaichamber.dcmiddleware.service.UserRegistrationService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {
    private final UserRegistrationClient userRegistrationClient;
    @Override
    public Object registerUser(Object request) {
        return userRegistrationClient.registerUser(request);
    }
}

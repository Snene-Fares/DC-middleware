package org.dubaichamber.dcmiddleware.service;

import org.dubaichamber.dcmiddleware.dto.userregistration.SimpleUserRegistrationRequestDTO;
import org.dubaichamber.dcmiddleware.dto.userregistration.UserRegistrationRequestDTO;

public interface UserRegistrationService {
    Object registerUser(SimpleUserRegistrationRequestDTO request);
}

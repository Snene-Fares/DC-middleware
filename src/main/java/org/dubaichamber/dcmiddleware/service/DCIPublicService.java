package org.dubaichamber.dcmiddleware.service;

import org.dubaichamber.dcmiddleware.dto.dcipublic.*;

import java.util.List;

public interface DCIPublicService {
    List<SimpleTermsConditionsDto> getTermsConditions ();
    List<SimpleFaqDto> getFaqs();

    ContactUsResponseDto contactUs(ContactUsRequestDto request);

    List<SimpleUpcomingEventCardDto> getUpcomingEvents();
    UpcomingEventDetailsDto getUpcomingEventDetails(Long  id);


}

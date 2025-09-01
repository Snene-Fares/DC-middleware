package org.dubaichamber.dcmiddleware.service.impl;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.client.DCIPublicClient;
import org.dubaichamber.dcmiddleware.dto.dcipublic.*;
import org.dubaichamber.dcmiddleware.mapper.DCIPublicMapper;
import org.dubaichamber.dcmiddleware.service.DCIPublicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DCIPublicServiceImpl implements DCIPublicService {
    private  final DCIPublicClient dciPublicClient;
    private final DCIPublicMapper dciPublicMapper;

    @Override
    public List<SimpleTermsConditionsDto> getTermsConditions() {
        TermsConditionsResponseDto response = dciPublicClient.getTermsConditions();
        return dciPublicMapper.mapTermsCondition(response);
    }

    @Override
    public List<SimpleFaqDto> getFaqs() {
        FaqResponseDto response = dciPublicClient.getFaqs();
        return dciPublicMapper.mapFaqs(response);
    }

    @Override
    public ContactUsResponseDto contactUs(ContactUsRequestDto request) {
        return dciPublicClient.contactUs(request);
    }

    @Override
    public List<SimpleUpcomingEventCardDto> getUpcomingEvents() {
        UpcomingEventsResponseDto response = dciPublicClient.getUpcomingEvents();
        return dciPublicMapper.mapUpcomingEventCards(response);
    }

    @Override
    public UpcomingEventDetailsDto getUpcomingEventDetails(Long id) {
        UpcomingEventsResponseDto response = dciPublicClient.getUpcomingEvents();
        if (response == null || response.getItems() == null) return null;

        return response.getItems().stream()
                .filter(item -> id.equals(item.getId()))
                .findFirst()
                .map(dciPublicMapper::mapEventDetails)
                .orElse(null);
    }
}

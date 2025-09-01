package org.dubaichamber.dcmiddleware.client;

import org.dubaichamber.dcmiddleware.client.config.CommonClientConfig;
import org.dubaichamber.dcmiddleware.client.config.DCIPublicClientConfig;
import org.dubaichamber.dcmiddleware.dto.dcipublic.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "dci-public-client", url = "${rest-ws.dci-public.base-url}" ,
        configuration = {CommonClientConfig.class , DCIPublicClientConfig.class}
)
public interface DCIPublicClient {
    @GetMapping("${rest-ws.dci-public.get-terms-conditions.url}")
    TermsConditionsResponseDto getTermsConditions ();

    @GetMapping("${rest-ws.dci-public.get-faqs.url}")
    FaqResponseDto getFaqs ();

    @PostMapping("${rest-ws.dci-public.contact-us.url}")
    ContactUsResponseDto contactUs(ContactUsRequestDto request);

    @GetMapping("${rest-ws.dci-public.get-upcoming-events.url}")
    UpcomingEventsResponseDto getUpcomingEvents();
}

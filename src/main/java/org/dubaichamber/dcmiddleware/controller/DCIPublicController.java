package org.dubaichamber.dcmiddleware.controller;

import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.dto.dcipublic.*;
import org.dubaichamber.dcmiddleware.service.DCIPublicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dci-public")
@RequiredArgsConstructor
public class DCIPublicController {
    private final DCIPublicService dciPublicService;

    @GetMapping("/terms-conditions")
    public ResponseEntity<List<SimpleTermsConditionsDto>> getTermsConditions() {
        return ResponseEntity.ok(dciPublicService.getTermsConditions());
    }

    @GetMapping("/faqs")
    public ResponseEntity<List<SimpleFaqDto>> getFaqs() {
        return ResponseEntity.ok(dciPublicService.getFaqs());
    }

    @PostMapping("/contact-us")
    public ResponseEntity<ContactUsResponseDto>getFaqs(@RequestBody ContactUsRequestDto contactUsRequestDto) {
        return ResponseEntity.ok(dciPublicService.contactUs(contactUsRequestDto));
    }

    @GetMapping("/upcoming-events")
    public ResponseEntity<List<SimpleUpcomingEventCardDto>> getUpcomingEvents() {
        return ResponseEntity.ok(dciPublicService.getUpcomingEvents());
    }

    @GetMapping("/upcoming-events/{id}")
    public ResponseEntity<UpcomingEventDetailsDto> getUpcomingEventDetails(@PathVariable Long  id) {
        return ResponseEntity.ok(dciPublicService.getUpcomingEventDetails(id));
    }
}

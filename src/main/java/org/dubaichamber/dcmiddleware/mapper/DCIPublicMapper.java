package org.dubaichamber.dcmiddleware.mapper;

import org.dubaichamber.dcmiddleware.dto.dcipublic.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mapper(componentModel = "spring")
public interface DCIPublicMapper {
    String FAQ_TITLE = "FAQ Title";
    String FAQ_DESCRIPTION = "FAQ Description";


    default List<SimpleTermsConditionsDto> mapTermsConditions(TermsConditionsResponseDto response) {
        List<SimpleTermsConditionsDto> result = new ArrayList<>();

        if (response == null || response.getItems() == null) {
            return result;
        }

        response.getItems().forEach(item -> {
            SimpleTermsConditionsDto dto = new SimpleTermsConditionsDto();
            dto.setId(item.getId());
            item.getContentFields().forEach(field -> {
                if ("FAQ Title".equals(field.getLabel())) {
                    dto.setTitle(field.getContentFieldValue().getData());
                }
                if ("FAQ Description".equals(field.getLabel())) {
                    dto.setDescription(field.getContentFieldValue().getData());
                }
            });

            result.add(dto);
        });

        return result;
    }

    default List<SimpleTermsConditionsDto> mapTermsCondition(TermsConditionsResponseDto response) {
        if (Objects.isNull(response)) {
            return Collections.emptyList();
        }
        return  response.getItems().stream()
                .flatMap(itemDto -> safeStream(itemDto.getContentFields()))
                .filter(Objects::nonNull)
                .filter(contentFieldDto -> FAQ_TITLE.equals(contentFieldDto.getLabel()) || FAQ_DESCRIPTION.equals(contentFieldDto.getLabel()))
                .map(this::mapTermsCondition)
                .toList();
    }

    default <T> Stream<T> safeStream(Collection<T> collection) {
        return Optional.ofNullable(collection)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull);
    }
    @Mapping(source = "label", target = "title")
    @Mapping(source = "contentFieldValue.data", target = "description")
    SimpleTermsConditionsDto mapTermsCondition(TermsConditionsResponseDto.ContentFieldDto contentFieldDto);

    default List<SimpleFaqDto> mapFaqs(FaqResponseDto response) {
        if (response == null || response.getItems() == null) return List.of();

        return response.getItems().stream().map(item -> {
            SimpleFaqDto dto = new SimpleFaqDto();
            dto.setId(item.getId());

            if (item.getTitle() != null) dto.setTitle(item.getTitle());
            if (item.getDescription() != null) dto.setHtmlDescription(item.getDescription());

            if (item.getContentFields() != null) {
                item.getContentFields().forEach(field -> {
                    if ("dcFAQTitle".equals(field.getName()) || "FAQ Title".equals(field.getLabel())) {
                        dto.setTitle(field.getContentFieldValue().getData());
                    }
                    if ("dcFAQDescription".equals(field.getName()) || "FAQ Description".equals(field.getLabel())) {
                        dto.setHtmlDescription(field.getContentFieldValue().getData());
                    }
                });
            }

            return dto;
        }).toList();
    }

    default List<SimpleUpcomingEventCardDto> mapUpcomingEventCards(UpcomingEventsResponseDto response) {
        if (response == null || response.getItems() == null) {
            return List.of();
        }

        return response.getItems().stream().map(item -> {
            SimpleUpcomingEventCardDto dto = new SimpleUpcomingEventCardDto();
            dto.setId(item.getId());
            dto.setTitle(item.getTitle());

            if (item.getContentFields() != null) {
                item.getContentFields().forEach(field -> {
                    switch (field.getName()) {
                        case "UpcomingEventDate", "eventdate" -> dto.setDate(field.getContentFieldValue().getData());
                        case "UpcomingEventTime" -> dto.setTime(field.getContentFieldValue().getData());
                        case "UpcomingEventPreview" -> {
                            if (field.getContentFieldValue() != null &&
                                    field.getContentFieldValue().getImage() != null) {
                                dto.setImageUrl(field.getContentFieldValue().getImage().getContentUrl());
                            }
                        }
                        case "EventVenue", "EventLocation" -> dto.setLocation(field.getContentFieldValue().getData());
                    }
                });
            }
            return dto;
        }).collect(Collectors.toList());
    }

    default UpcomingEventDetailsDto mapEventDetails(UpcomingEventsResponseDto.StructuredContentItem item) {
        if (item == null) return null;

        UpcomingEventDetailsDto dto = new UpcomingEventDetailsDto();
        dto.setId(item.getId());
        dto.setTitle(item.getTitle());

        if (item.getContentFields() != null) {
            item.getContentFields().forEach(field -> {
                switch (field.getName()) {
                    case "UpcomingEventDescription" -> dto.setOverview(field.getContentFieldValue().getData());
                    case "UpcomingEventDate", "eventdate" -> dto.setDate(field.getContentFieldValue().getData());
                    case "UpcomingEventTime" -> dto.setTime(field.getContentFieldValue().getData());
                    case "EventVenue" -> dto.setVenue(field.getContentFieldValue().getData());
                    case "EventLocation" -> dto.setLocation(field.getContentFieldValue().getData());
                    case "HostedBy" -> dto.setHostedBy(field.getContentFieldValue().getData());
                    case "EventType" -> dto.setEventType(field.getContentFieldValue().getData());
                    case "Objectives" -> {
                        if (field.getNestedContentFields() != null) {
                            dto.setObjectives(
                                    field.getNestedContentFields().stream()
                                            .map(f -> f.getContentFieldValue().getData())
                                            .toList()
                            );
                        }
                    }
                    case "EventPricing" -> {
                        UpcomingEventDetailsDto.Pricing pricing = new UpcomingEventDetailsDto.Pricing();
                        if (field.getNestedContentFields() != null) {
                            field.getNestedContentFields().forEach(nf -> {
                                switch (nf.getName()) {
                                    case "MemberAmount" -> pricing.setMemberAmount(nf.getContentFieldValue().getData());
                                    case "NonMemberAmount" -> pricing.setNonMemberAmount(nf.getContentFieldValue().getData());
                                    case "Discount" -> pricing.setDiscount(nf.getContentFieldValue().getData());
                                    case "EventCode" -> pricing.setEventCode(nf.getContentFieldValue().getData());
                                }
                            });
                        }
                        dto.setPricing(pricing);
                    }
                    case "PricingDescription" -> dto.setPricingDescription(field.getContentFieldValue().getData());
                    case "EventExternalLink" -> dto.setExternalLink(field.getContentFieldValue().getData());
                }
            });
        }
        return dto;
    }


}

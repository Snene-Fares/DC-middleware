package org.dubaichamber.dcmiddleware.dto.dcipublic;

import lombok.Data;

import java.util.List;

@Data
public class UpcomingEventDetailsDto {
    private Long id;
    private String title;
    private String overview;
    private String date;
    private String time;
    private String venue;
    private String location;
    private String hostedBy;
    private String eventType;
    private List<String> objectives;
    private Pricing pricing;
    private String pricingDescription;
    private String externalLink;

    @Data
    public static class Pricing {
        private String memberAmount;
        private String nonMemberAmount;
        private String discount;
        private String eventCode;
    }
}

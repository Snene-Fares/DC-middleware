package org.dubaichamber.dcmiddleware.dto.dcipublic;

import lombok.Data;

@Data
public class SimpleUpcomingEventCardDto {
    private Long id;
    private String title;
    private String date;
    private String time;
    private String imageUrl;
    private String location;
}

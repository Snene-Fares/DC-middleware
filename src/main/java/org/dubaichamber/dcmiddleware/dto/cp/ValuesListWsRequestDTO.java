package org.dubaichamber.dcmiddleware.dto.cp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValuesListWsRequestDTO {
    private Body body;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Body {
        @JsonProperty("LanguageCode")
        private String languageCode;
        @JsonProperty("ParentValue")
        private String parentValue;
        @JsonProperty("ProcessName")
        private String processName;
        @JsonProperty("SubType")
        private String subType;
        @JsonProperty("Type")
        private String type;
    }
}

package org.dubaichamber.dcmiddleware.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizeResponseWsDTO {
    private String flowId;
    private String flowStatus;
    private String flowType;
    private NextStep nextStep;
    private List<Link> links;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class NextStep {
        private String stepType;
        private List<Authenticator> authenticators;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Authenticator {
        private String authenticatorId;
        private String authenticator;
        private String idp;
        private Metadata metadata;
        private List<String> requiredParams;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Metadata {
            private String i18nKey;
            private String promptType;
            private List<Param> params;

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Param {
                private String param;
                private String type;
                private int order;
                private String i18nKey;
                private String displayName;
                private boolean confidential;
            }
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Link {
        private String name;
        private String href;
        private String method;
    }
}

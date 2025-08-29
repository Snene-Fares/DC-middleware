package org.dubaichamber.dcmiddleware.dto.dcipublic;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class FaqResponseDto {
    private List<FaqItem> items;
    private int page;
    private int pageSize;
    private int totalCount;
    private int lastPage;

    @Data
    public static class FaqItem {
        private String id;
        private String uuid;
        private String title;
        private String description;
        private String friendlyUrlPath;
        private ZonedDateTime dateCreated;
        private ZonedDateTime dateModified;
        private ZonedDateTime datePublished;
        private Creator creator;
        private List<String> availableLanguages;
        private List<TaxonomyCategoryBrief> taxonomyCategoryBriefs;

        private List<ContentField> contentFields;

        @Data
        public static class ContentField {
            private String label;
            private String name;
            private ContentFieldValue contentFieldValue;

            @Data
            public static class ContentFieldValue {
                private String data;
            }
        }
    }

    @Data
    public static class Creator {
        private Long id;
        private String name;
        private String givenName;
        private String familyName;
        private String contentType;
        private String additionalName;
    }

    @Data
    public static class TaxonomyCategoryBrief {
        private Long taxonomyCategoryId;
        private String taxonomyCategoryName;
    }
}

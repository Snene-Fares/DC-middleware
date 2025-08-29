package org.dubaichamber.dcmiddleware.dto.dcipublic;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
@Data
public class UpcomingEventsResponseDto {
    private List<StructuredContentItem> items;
    private int page;
    private int pageSize;
    private int totalCount;
    private int lastPage;

    @Data
    public static class StructuredContentItem {
        private Long id;
        private String uuid;
        private String title;
        private String description;
        private String friendlyUrlPath;
        private String externalReferenceCode;
        private String key;
        private Long siteId;
        private Long contentStructureId;
        private Long structuredContentFolderId;
        private List<String> availableLanguages;
        private List<String> keywords;
        private Double priority;
        private Integer numberOfComments;
        private Boolean subscribed;

        private OffsetDateTime dateCreated;
        private OffsetDateTime dateModified;
        private OffsetDateTime datePublished;

        private Creator creator;
        private List<TaxonomyCategoryBrief> taxonomyCategoryBriefs;
        private List<RelatedContent> relatedContents;
        private List<RenderedContent> renderedContents;

        private List<ContentField> contentFields;
    }

    @Data
    public static class Creator {
        private Long id;
        private String name;
        private String givenName;
        private String familyName;
        private String additionalName;
        private String contentType;
        private String image;
    }

    @Data
    public static class TaxonomyCategoryBrief {
        private Long taxonomyCategoryId;
        private String taxonomyCategoryName;
    }

    @Data
    public static class RelatedContent {
        private String contentType;
        private Long id;
        private String title;
    }

    @Data
    public static class RenderedContent {
        private String contentTemplateId;
        private String contentTemplateName;
        private Boolean markedAsDefault;
        private String renderedContentURL;
    }

    @Data
    public static class ContentField {
        private String name;
        private String label;
        private String dataType;
        private String inputControl;
        private Boolean repeatable;
        private ContentFieldValue contentFieldValue;
        private List<ContentField> nestedContentFields;
    }

    @Data
    public static class ContentFieldValue {
        private String data;
        private Image image;
    }

    @Data
    public static class Image {
        private String contentType;
        private String contentUrl;
        private String description;
        private String encodingFormat;
        private String fileExtension;
        private Long id;
        private Long sizeInBytes;
        private String title;
    }
}

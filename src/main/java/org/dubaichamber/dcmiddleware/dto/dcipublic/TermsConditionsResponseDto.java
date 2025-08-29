package org.dubaichamber.dcmiddleware.dto.dcipublic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TermsConditionsResponseDto {
    private ActionsDto actions;
    private List<Object> facets;
    private List<ItemDto> items;
    private int lastPage;
    private int page;
    private int pageSize;
    private int totalCount;

    @Data
    public static class ActionsDto {
        private ActionDetailDto get;
    }

    @Data
    public static class ActionDetailDto {
        private String method;
        private String href;
    }

    @Data
    public static class ItemDto {
        private ItemActionsDto actions;
        private List<String> availableLanguages;
        private List<ContentFieldDto> contentFields;
        private long contentStructureId;
        private CreatorDto creator;
        private List<Object> customFields;
        private String dateCreated;
        private String dateModified;
        private String datePublished;
        private String description;
        private String externalReferenceCode;
        private String friendlyUrlPath;
        private long id;
        private String key;
        private List<String> keywords;
        private int numberOfComments;
        private double priority;
        private List<Object> relatedContents;
        private List<Object> renderedContents;
        private long siteId;
        private long structuredContentFolderId;
        private boolean subscribed;
        private List<Object> taxonomyCategoryBriefs;
        private String title;
        private String uuid;
    }

    @Data
    public static class ItemActionsDto {
        private ActionDetailDto get;

        @JsonProperty("get-rendered-content")
        private ActionDetailDto getRenderedContent;

        @JsonProperty("get-rendered-content-by-display-page")
        private ActionDetailDto getRenderedContentByDisplayPage;
    }

    @Data
    public static class ContentFieldDto {
        private ContentFieldValueDto contentFieldValue;
        private String dataType;
        private String inputControl;
        private String label;
        private String name;
        private List<Object> nestedContentFields;
        private boolean repeatable;
    }

    @Data
    public static class ContentFieldValueDto {
        private String data;
    }

    @Data
    public static class CreatorDto {
        private String additionalName;
        private String contentType;
        private String familyName;
        private String givenName;
        private long id;
        private String name;
    }
}

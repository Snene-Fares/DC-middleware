package org.dubaichamber.dcmiddleware.dto.scimusermanagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScimUserListWsResponseDTO {
    private int totalResults;
    private int startIndex;
    private int itemsPerPage;
    private List<String> schemas;
    @JsonProperty("Resources")
    private List<Resource> resources;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Resource {
        private List<String> emails;
        private Meta meta;
        private List<Role> roles;
        private Name name;
        private String id;
        private String userType;
        private String userName;
        private String title;
        @JsonProperty("urn:scim:wso2:schema")
        private ScimWso2Extension scimWso2Extension;
        @JsonProperty("urn:ietf:params:scim:schemas:extension:enterprise:2.0:User")
        private EnterpriseUserExtension enterpriseUserExtension;
        private List<PhoneNumber> phoneNumbers;


        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Meta(
                String created,
                String location,
                String lastModified,
                String resourceType
        ) {}

        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Role(
                String audienceValue,
                String display,
                String audienceType,
                String value,
                String ref,
                String audienceDisplay
        ) {}

        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Name(
                String givenName,
                String familyName
        ) {}

        @JsonIgnoreProperties(ignoreUnknown = true)
        public record ScimWso2Extension(
                String emiratesId
        ) {}

        @JsonIgnoreProperties(ignoreUnknown = true)
        public record EnterpriseUserExtension(
                String country
        ) {}

        @JsonIgnoreProperties(ignoreUnknown = true)
        public record PhoneNumber(
                String type,
                String value
        ) {}
    }
}

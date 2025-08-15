package org.dubaichamber.dcmiddleware.dto.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticateResponseWsDTO {
    private String flowStatus;
    private AuthData authData;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AuthData {
        private String code;
        private String state;
        private String sessionState; // Note: session_state in JSON maps to sessionState in Java

        // Custom setter for session_state to handle JSON naming
        @JsonProperty("session_state")
        public void setSessionState(String sessionState) {
            this.sessionState = sessionState;
        }

        @JsonProperty("session_state")
        public String getSessionState() {
            return sessionState;
        }
    }
}

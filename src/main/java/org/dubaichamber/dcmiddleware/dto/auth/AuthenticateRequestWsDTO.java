package org.dubaichamber.dcmiddleware.dto.auth;

import lombok.Data;

@Data
public class AuthenticateRequestWsDTO {
    private String flowId;
    private SelectedAuthenticator selectedAuthenticator;

    @Data
    public static class SelectedAuthenticator {
        private String authenticatorId;
        private Params params;

        @Data
        public static class Params {
            private String username;
            private String password;
        }
    }
}

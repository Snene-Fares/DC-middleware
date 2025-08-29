package org.dubaichamber.dcmiddleware.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonUtils {

    public static String getBasicAuthorizationHeader(String username, String password) {
        return "Basic " + Base64.getEncoder().encodeToString(username.concat(":").concat(password).getBytes());
    }

    public static String filterFormatter(String filter) {
        return "userName eq \"" + filter + "\"";
    }
}

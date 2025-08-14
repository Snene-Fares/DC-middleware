package org.dubaichamber.dcmiddleware.util;

import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Component
public class PkceUtil {

    public String generateCodeVerifier() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] codeVerifier = new byte[32];
        secureRandom.nextBytes(codeVerifier);
        return Base64.encodeBase64URLSafeString(codeVerifier);
    }

    @SneakyThrows
    public String generateCodeChallenge(String codeVerifier){
        byte[] bytes = codeVerifier.getBytes(StandardCharsets.US_ASCII);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bytes, 0, bytes.length);
        byte[] digest = messageDigest.digest();
        return Base64.encodeBase64URLSafeString(digest);
    }
}

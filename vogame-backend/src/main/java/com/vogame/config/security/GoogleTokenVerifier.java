package com.vogame.config.security;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;

@Component
public class GoogleTokenVerifier {

    private static final HttpTransport transport = new NetHttpTransport();
    private static final JsonFactory jsonFactory = new JacksonFactory();
    private static final String CLIENT_ID = "797207972307-1v2d73fvbt1arm3r8t9mhgde3ier1n9i.apps.googleusercontent.com";


    public GoogleIdToken.Payload verify(String idTokenString)
            throws GeneralSecurityException, IOException, InvalidTokenException {
        return verifyToken(idTokenString);
    }

    private GoogleIdToken.Payload verifyToken(String idTokenString)
            throws GeneralSecurityException, IOException, InvalidTokenException {
        final GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.
                Builder(transport, jsonFactory)
                .setIssuers(Arrays.asList("https://accounts.google.com", "accounts.google.com"))
                .setAudience(Collections.singletonList(CLIENT_ID))
                .build();


        System.out.println("validating:" + idTokenString);

        GoogleIdToken idToken = null;
        try {
            idToken = verifier.verify(idTokenString);
        } catch (IllegalArgumentException e){
            // means token was not valid and idToken
            // will be null
        }

        if (idToken == null) {
            throw new InvalidTokenException("idToken is invalid");
        }

        return idToken.getPayload();
    }
}

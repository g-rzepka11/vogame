package com.vogame.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Component
public class GoogleTokenAuthenticationFilter implements Filter {

    private GoogleTokenVerifier googleTokenVerifier;
    private AppTokenProvider appTokenProvider;

    public GoogleTokenAuthenticationFilter(GoogleTokenVerifier googleTokenVerifier,
                                           AppTokenProvider appTokenProvider) {
        this.googleTokenVerifier = googleTokenVerifier;
        this.appTokenProvider = appTokenProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String idToken = ((HttpServletRequest) servletRequest).getHeader("X-ID-TOKEN");

        if (idToken != null) {
            try {
                GoogleIdToken.Payload payload = googleTokenVerifier.verify(idToken);
                if (payload != null) {
                    String username = payload.getSubject();
                    HttpServletResponse response = (HttpServletResponse) servletResponse;
                    appTokenProvider.addAuthentication(response, username);
                    filterChain.doFilter(servletRequest, response);
                    return;
                }
            } catch (GeneralSecurityException | InvalidTokenException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}

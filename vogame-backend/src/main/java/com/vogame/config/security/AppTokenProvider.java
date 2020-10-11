package com.vogame.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Component
public class AppTokenProvider {

    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";

    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    public AppTokenProvider(JwtConfig jwtConfig, SecretKey secretKey) {
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
    }

    public void addAuthentication(HttpServletResponse res, String userId) {
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + getNewPerishableToken(userId));
    }

    private String getNewPerishableToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())))
                .signWith(secretKey)
                .compact();
    }

    public Optional<String> getUserFromToken(HttpServletRequest request) {
        final String token = request.getHeader(jwtConfig.getAuthorizationHeader());

        if (token != null) {
            try {
                Jws<Claims> claimsJws = Jwts.parser()
                        .setSigningKey(secretKey)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""));

                Claims body = claimsJws.getBody();

                final Instant expiration = body.getExpiration().toInstant();

                if (expiration.isBefore(Instant.now())) {
                    return Optional.empty();
                }
                return Optional.of(body.getSubject());

            } catch (RuntimeException e) {
                // invalid signature
            }
        }
        return Optional.empty();
    }
}

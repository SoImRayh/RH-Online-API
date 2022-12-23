package com.soimrayh.systemapi.util.oauth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.soimrayh.systemapi.service.implementation.UserDetailsImplementation;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.time.Instant;
import java.util.Date;

@Component
@Log4j2
public class JwtUtil {
    //@Value("${rayh.dev.jwtSecret}")
    private String jwtSecret = "mysecret";

    //@Value("${rayh.dev.jwtExpirationMs}")
    private final int jwtExpirationMs = 10000000;

    public String generateJwtToken(Authentication authentication) {
        UserDetailsImplementation userPrincipal = (UserDetailsImplementation) authentication.getPrincipal();
        return JWT.create().withSubject((userPrincipal.getUsername()))
                .withExpiresAt(new Date((new Date().getTime()+ jwtExpirationMs))  )
                .sign(Algorithm.HMAC512(jwtSecret));
    }

    public String getUsernameFromJwtToken(String token){
        return JWT.require(Algorithm.HMAC512(jwtSecret)).build().verify(token).getSubject();
    }

    public boolean validateJwtToken(String jwt) {

        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(jwtSecret)).build().verify(jwt);
            if (decodedJWT.getExpiresAt().getTime() > (new Date()).getTime())
                return true;
        }catch (TokenExpiredException e){
            log.error("token expirado: {}", e.getMessage());
        } catch (Exception e){
            log.error("algum problema com o toke: {}", e.getMessage());
        }
        return false;
    }
}

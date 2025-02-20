package com.xb.rsc_api_gateway.security;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.security.web.webauthn.authentication.WebAuthnAuthentication;
import org.springframework.security.web.webauthn.authentication.WebAuthnAuthenticationRequestToken;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Component
public class CustomAuthenticationConverter implements ServerAuthenticationConverter {


    @Autowired
    JWTUtil jwtUtil;


    public Mono<Authentication> convert(ServerWebExchange exchange) {
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            return Mono.just(createAuthentication(token));
        }
        return Mono.empty();
    }

    private Authentication createAuthentication(String token) {
        String username = (String) jwtUtil.extractUsername(token);  // Extract subject (username) from JWT
        return new UsernamePasswordAuthenticationToken(username, token, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}

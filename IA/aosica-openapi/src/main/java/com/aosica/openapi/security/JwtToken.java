package com.aosica.openapi.security;

import org.apache.shiro.authc.AuthenticationToken;


/**
 * open token
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public String toString() {
        return "JwtToken{" +
            "token='" + token + '\'' +
            '}';
    }
}
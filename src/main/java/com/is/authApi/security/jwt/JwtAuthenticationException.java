package com.is.authApi.security.jwt;


import org.springframework.security.core.AuthenticationException;

/**
 * Created by User on 15.11.2019
 */
public class JwtAuthenticationException extends AuthenticationException {

    public JwtAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}

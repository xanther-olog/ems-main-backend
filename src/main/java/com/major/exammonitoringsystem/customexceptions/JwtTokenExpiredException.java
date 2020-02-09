package com.major.exammonitoringsystem.customexceptions;

public class JwtTokenExpiredException extends Exception {
    public JwtTokenExpiredException(String message) {
        super(message);
    }
}

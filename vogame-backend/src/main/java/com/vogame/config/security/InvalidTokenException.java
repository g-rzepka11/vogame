package com.vogame.config.security;

public class InvalidTokenException extends Exception{

    public InvalidTokenException() {
        super();
    }
    public InvalidTokenException(String msg) {
        super(msg);
    }
}

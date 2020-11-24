package com.vogame.exception;

public class LearnUserNotExistsException extends Exception {

    public LearnUserNotExistsException(String message) {
        super(message);
    }

    public LearnUserNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

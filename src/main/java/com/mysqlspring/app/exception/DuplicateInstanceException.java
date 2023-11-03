package com.mysqlspring.app.exception;

public class DuplicateInstanceException extends RuntimeException{

    public DuplicateInstanceException(String message) {
        super(message);
    }
}

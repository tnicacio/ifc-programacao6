package com.tnicacio.paypayapi.exception.serviceexception;

public class DatabaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DatabaseException(String msg) {
        super(msg);
    }

}

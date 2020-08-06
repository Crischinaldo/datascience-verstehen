package org.web.restapi.exception;

public class BaseApiException extends Exception {

    private String message;

    public BaseApiException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.yolocc.tabsdemo;

/**
 */
public abstract class BaseModel {

    private String error;

    private String message;

    protected BaseModel(String error, String message) {
        this.error = error;
        this.message = message;
    }

    protected String getError() {
        return error;
    }

    protected void setError(String error) {
        this.error = error;
    }

    protected String getMessage() {
        return message;
    }

    protected void setMessage(String message) {
        this.message = message;
    }
}

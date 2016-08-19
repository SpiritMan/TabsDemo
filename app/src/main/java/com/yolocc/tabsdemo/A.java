package com.yolocc.tabsdemo;

/**
 */
public class A<T> {
    public boolean isSuccess;

    public String data;

    public A(boolean isSuccess, String data) {
        this.isSuccess = isSuccess;
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

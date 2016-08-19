package com.yolocc.tabsdemo;

/**
 */
public class B extends A{

    public String data;

    public B(boolean isSuccess, String data) {
        super(isSuccess, data);
    }

    public B(boolean isSuccess, String data, String data1) {
        super(isSuccess, data);
        this.data = data1;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }
}

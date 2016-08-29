/*
 * -----------------------------
 * Copyright (C) 2016, 上海宅米贸易有限公司, All rights reserved.
 * -----------------------------
 * File: ${NAME}.java
 * Author: LongLe
 *
 */

package com.yolocc.tabsdemo;


/**
 * 网络返回结果对固定格式进行封装
 */
public class HttpResult<T> {

    public boolean success;
    private T Data;

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

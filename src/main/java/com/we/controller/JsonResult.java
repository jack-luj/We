package com.we.controller;

/**
 * Created by jackl on 2016/12/1.
 */
public class JsonResult {
    private String status;
    private Object message;

    public JsonResult(String status, Object message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}

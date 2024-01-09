package com.restpractice.restpractice.practice1.errorHandling;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

public class PlayerErrorResponse {
    @JsonFormat(pattern = "yyyy-MM-dd:HH:mm:ss")
    private ZonedDateTime timeStamp;
    private int statusCode;
    private String path;
    private String message;

    public PlayerErrorResponse() {
        super();
    }

    public PlayerErrorResponse(ZonedDateTime timeStamp, int statusCode, String path, String message) {
        super();
        this.timeStamp = timeStamp;
        this.statusCode = statusCode;
        this.path = path;
        this.message = message;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getPath() {
        return path;
    }

    public String getMessage() {
        return message;
    }

    public void setTimeStamp(ZonedDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

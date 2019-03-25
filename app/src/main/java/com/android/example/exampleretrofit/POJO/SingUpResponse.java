package com.android.example.exampleretrofit.POJO;


/**
 * This POJO class gets the data from API
 */
public class SingUpResponse {
    String success;
    String message;
    Integer userId;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

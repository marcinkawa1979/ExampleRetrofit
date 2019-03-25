package com.android.example.exampleretrofit.POJO;

public class Data {
    private Integer id;
    private String email;
    private String apiToken;
    private ApiTokenExpires apiTokenExpires;
    private String createdAt;
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public ApiTokenExpires getApiTokenExpires() {
        return apiTokenExpires;
    }

    public void setApiTokenExpires(ApiTokenExpires apiTokenExpires) {
        this.apiTokenExpires = apiTokenExpires;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
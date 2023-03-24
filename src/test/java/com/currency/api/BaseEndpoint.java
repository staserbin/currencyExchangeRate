package com.currency.api;

public class BaseEndpoint {

    private String baseUrl;
    private String extraUrl;

    public BaseEndpoint(String baseUrl, String extraUrl) {
        this.baseUrl = baseUrl;
        this.extraUrl = extraUrl;
    }

    public String getExtraUrl() {
        return extraUrl;
    }

    public void setExtraUrl(String extraUrl) {
        this.extraUrl = extraUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}

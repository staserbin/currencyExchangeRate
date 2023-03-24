package com.currency.api;

public class BaseEndpoint {
    private String extraUrl;

    public BaseEndpoint(String extraUrl) {
        this.extraUrl = extraUrl;
    }

    public String getExtraUrl() {
        return extraUrl;
    }

    public void setExtraUrl(String extraUrl) {
        this.extraUrl = extraUrl;
    }
}

package com.java.learning.lld.tinyUrl.way2;

public class UrlShortCode {
    private String url;
    private String shortCode;

    public UrlShortCode(String url, String shortCode) {
        this.url = url;
        this.shortCode = shortCode;
    }

    public String getUrl() {
        return url;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
}

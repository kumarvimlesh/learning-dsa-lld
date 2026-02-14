package com.java.learning.lld.tinyUrl.way2;

import java.util.HashMap;
import java.util.Map;

public class UrlShortnerRepository {
    private final Map<String, UrlShortCode> urlShortCodeMap = new HashMap<>();
    private static UrlShortnerRepository instance;

    public static UrlShortnerRepository getInstance() {
        if (instance == null) {
            instance = new UrlShortnerRepository();
        }
        return instance;
    }

    public UrlShortCode save(UrlShortCode urlShortCode) {
        urlShortCodeMap.put(urlShortCode.getShortCode(), urlShortCode);
        return urlShortCode;
    }

    public UrlShortCode findById(String id) {
        return urlShortCodeMap.get(id);
    }
}

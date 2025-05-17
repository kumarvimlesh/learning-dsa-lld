package com.java.learning.lld.tinyUrl.service;

import com.java.learning.lld.tinyUrl.model.TinyUrl;

import java.util.List;

public interface TinyUrlService {
    String getShortUrl(String url);
    String getOriginalUrl(String code);
    List<TinyUrl> getAllTinyUrls();
}

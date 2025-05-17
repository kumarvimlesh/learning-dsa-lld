package com.java.learning.lld.tinyUrl.service.impl;

import com.java.learning.lld.tinyUrl.model.TinyUrl;
import com.java.learning.lld.tinyUrl.repository.TinyUrlRepository;
import com.java.learning.lld.tinyUrl.service.TinyUrlService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TinyUrlServiceImpl implements TinyUrlService {
    private final TinyUrlRepository tinyUrlRepository = TinyUrlRepository.getInstance();
    private final String BASE_TINY_URL = "http://tiny-url/";

    @Override
    public String getShortUrl(String url) {
        Optional<TinyUrl> tinyUrlOptional = tinyUrlRepository.findByUrl(url);
        if (tinyUrlOptional.isPresent()) return tinyUrlOptional.get().getUrlCode();
        TinyUrl tinyUrl = new TinyUrl();
        tinyUrl.setId(UUID.randomUUID().toString());
        tinyUrl.setUrlCode(BASE_TINY_URL + tinyUrl.getId().substring(0, 5));
        tinyUrl.setUrl(url);
        return tinyUrlRepository.save(tinyUrl).getUrlCode();
    }

    @Override
    public String getOriginalUrl(String code) {
        Optional<TinyUrl>  tinyUrlOptional = tinyUrlRepository.findByUrlCode(code);
        if (tinyUrlOptional.isPresent()) return tinyUrlOptional.get().getUrl();
        else throw new RuntimeException("Url not found for code : " + code);
    }

    @Override
    public List<TinyUrl> getAllTinyUrls() {
        return tinyUrlRepository.findAll();
    }
}

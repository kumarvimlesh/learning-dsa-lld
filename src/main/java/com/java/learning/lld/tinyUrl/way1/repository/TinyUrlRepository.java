package com.java.learning.lld.tinyUrl.way1.repository;

import com.java.learning.lld.tinyUrl.way1.model.TinyUrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TinyUrlRepository {
    private static TinyUrlRepository instance;
    private final List<TinyUrl> tinyUrls = new ArrayList<>();
    private final int counter = 0;

    public static TinyUrlRepository getInstance(){
        if (instance == null){
            instance = new TinyUrlRepository();
        }
        return instance;
    }

    public TinyUrl save(TinyUrl tinyUrl){
        this.tinyUrls.add(tinyUrl);
        return tinyUrl;
    }

    public Optional<TinyUrl> findByUrlCode(String urlCode){
        return this.tinyUrls.stream().filter(tinyUrl -> tinyUrl.getUrlCode().equals(urlCode)).findFirst();
    }

    public Optional<TinyUrl> findByUrl(String url){
        return this.tinyUrls.stream().filter(tinyUrl -> tinyUrl.getUrl().equals(url)).findFirst();
    }

    public List<TinyUrl> findAll() {
        return this.tinyUrls;
    }
}

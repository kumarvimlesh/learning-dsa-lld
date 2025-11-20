package com.java.learning.lld.tinyUrl.way2;

import java.util.UUID;
import java.util.stream.Stream;

public class UrlShortnerApp {
    public static void main(String[] args) {
        UrlShortnerService urlShortner = new UrlShortnerService();

        Stream.iterate(0, i -> i + 1).limit(50).forEach(num ->{
            UrlShortCode shortUrlCode2 = urlShortner.generateShortUrl("https://www.google.com" + UUID.randomUUID());
            System.out.println("Short code: " + shortUrlCode2.getShortCode());
            System.out.println("Long URL: " + urlShortner.getUrl(shortUrlCode2.getShortCode()));
        });
    }


}

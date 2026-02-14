package com.java.learning.lld.tinyUrl.way2;

public class UrlShortnerService {
    private final UrlShortnerRepository urlShortnerRepository = UrlShortnerRepository.getInstance();
    private final NumberRangeRepository numberRangeRepository = NumberRangeRepository.getInstance();
    private static final String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int BASE = alphaNumericString.length();

    public UrlShortCode generateShortUrl(String url) {
        UrlShortCode urlShortCode = new UrlShortCode(url, generateShortCode());
        return urlShortnerRepository.save(urlShortCode);
    }

    public String getUrl(String shortCode) {
        return urlShortnerRepository.findById(shortCode).getUrl();
    }

    private String generateShortCode() {
        return encodeBase62(numberRangeRepository.getRandomNumberRange());
    }

    private String encodeBase62(int num) {
        if (num == 0) return "A";
        StringBuilder stringBuilder = new StringBuilder();
        while (num>0){
            stringBuilder.append(alphaNumericString.charAt(num%BASE));
            num /= BASE;
        }
        return stringBuilder.reverse().toString();
    }
}

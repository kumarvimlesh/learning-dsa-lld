package com.java.learning.lld.tinyUrl.way1;

import com.java.learning.lld.tinyUrl.way1.model.TinyUrl;
import com.java.learning.lld.tinyUrl.way1.service.TinyUrlService;
import com.java.learning.lld.tinyUrl.way1.service.impl.TinyUrlServiceImpl;

import java.util.List;

public class TinyUrlApplication {
    public static void main(String[] args) {
        TinyUrlService tinyUrlService = new TinyUrlServiceImpl();

        String url = "https://vimlesh.com/cover-letter";
        String tinyUrl =  tinyUrlService.getShortUrl(url);
        System.out.println("Tiny url for "+ url + " : "+ tinyUrl);
        System.out.println("Original url for tiny url " + tinyUrl + " : " + tinyUrlService.getOriginalUrl(tinyUrl));

        System.out.println();
        String url2 = "https://vimlesh.com/resume";
        String tinyUrl2 =  tinyUrlService.getShortUrl(url2);
        System.out.println("Tiny url for "+ url2 + " : "+ tinyUrl2);
        System.out.println("Original url for tiny url " + tinyUrl2 + " : " + tinyUrlService.getOriginalUrl(tinyUrl2));

        System.out.println();
        List<TinyUrl> tinyUrls = tinyUrlService.getAllTinyUrls();
        for (TinyUrl tiny : tinyUrls){
            System.out.println(tiny.getUrlCode() + "    " + tiny.getUrl());
        }

    }
}

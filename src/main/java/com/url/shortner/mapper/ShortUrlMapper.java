package com.url.shortner.mapper;

import com.url.shortner.domain.ShortUrl;
import com.url.shortner.representer.ShortUrlRepresenter;

public class ShortUrlMapper {

    public static ShortUrl toDomain(String key, String url){
        return ShortUrl.builder()
                .id(key)
                .url(url)
                .build();
    }

    public static ShortUrlRepresenter toRepresenter(ShortUrl shortUrl){
        return ShortUrlRepresenter.builder()
                .key(shortUrl.getId())
                .shortUrl(shortUrl.getUrl())
                .build();
    }
}

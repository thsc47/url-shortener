package com.url.shortner.mapper;

import com.url.shortner.domain.ShortUrl;

public class ShortUrlMapper {

    public static ShortUrl toDomain(String url){
        return ShortUrl.builder()
                .url(url)
                .build();
    }
}

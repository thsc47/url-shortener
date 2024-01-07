package com.github.shortener.urlshortener.services;

import com.github.shortener.urlshortener.dtos.UrlDto;

public interface UrlService {

    UrlDto shortUrl(String url);

    String getOriginalUrl(String shortUrl);
}

package com.github.shortener.urlshortener.services;

import com.github.shortener.urlshortener.dtos.UrlDto;

public interface UrlService {

    UrlDto shortUrl(String url);

    UrlDto getOriginalUrl(String shortUrl);
}

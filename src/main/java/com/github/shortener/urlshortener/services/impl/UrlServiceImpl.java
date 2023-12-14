package com.github.shortener.urlshortener.services.impl;

import com.github.shortener.urlshortener.services.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UrlServiceImpl implements UrlService {

    @Override
    public String shortUrl(String url) {
        return null;
    }
}

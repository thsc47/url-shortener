package com.github.shortener.urlshortener.services;

import com.github.shortener.urlshortener.domains.Url;

public interface UrlService {

    Url shortUrl(String url);
}

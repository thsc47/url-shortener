package com.url.shortner.service;

import com.url.shortner.domain.ShortUrl;

public interface ShortnerService {

    public ShortUrl shortUrl(String url);
}

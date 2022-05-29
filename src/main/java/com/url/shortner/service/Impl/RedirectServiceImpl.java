package com.url.shortner.service.Impl;

import com.url.shortner.domain.ShortUrl;
import com.url.shortner.exception.NonExistentEntityException;
import com.url.shortner.repository.ShortnerUrlRepository;
import com.url.shortner.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;

public class RedirectServiceImpl implements RedirectService {

    @Autowired
    ShortnerUrlRepository shortnerUrlRepository;

    @Override
    public String getTrueUrl(String key) {
        return shortnerUrlRepository.findById(key)
                .orElseThrow(NonExistentEntityException::new)
                .getUrl();
    }
}

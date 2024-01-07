package com.github.shortener.urlshortener.services.impl;

import com.github.shortener.urlshortener.domains.Url;
import com.github.shortener.urlshortener.dtos.UrlDto;
import com.github.shortener.urlshortener.exceptions.errors.StandardUrlAlreadyExistsException;
import com.github.shortener.urlshortener.mappers.UrlMapper;
import com.github.shortener.urlshortener.repositories.UrlRepository;
import com.github.shortener.urlshortener.services.UrlService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;
    private final UrlMapper urlMapper;

    @Override
    public UrlDto shortUrl(String url) {
        urlRepository.findByOriginalUrl(url)
                .ifPresent(opt -> {
                    throw new StandardUrlAlreadyExistsException(url);
                });
        return urlMapper.toDto(shortenAnUrl(url));
    }

    @Override
    public String getOriginalUrl(String shortUrl) {
        return null;
        // TODO
    }

    private Url shortenAnUrl(String url) {
        final var salt = RandomStringUtils.random(8, true, true);
        return urlRepository.save(urlMapper.toDomain(url, salt));
    }
}

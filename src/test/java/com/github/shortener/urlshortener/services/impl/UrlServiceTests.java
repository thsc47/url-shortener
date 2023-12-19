package com.github.shortener.urlshortener.services.impl;

import com.github.shortener.urlshortener.domains.Url;
import com.github.shortener.urlshortener.mappers.UrlMapper;
import com.github.shortener.urlshortener.mappers.UrlMapperImpl;
import com.github.shortener.urlshortener.repositories.UrlRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import(UrlMapperImpl.class)
class UrlServiceTests {

    private static String URL_MOCK = "http://test";
    private static String SHORT_URL_MOCK = "http://test";

    @SpyBean
    private UrlServiceImpl urlService;

    @MockBean
    private UrlRepository urlRepository;

    @Test
    void shouldRegisterAShortUrl() {
        Url urlMock = new Url(1L, URL_MOCK, SHORT_URL_MOCK);
        when(urlRepository.findByOriginalUrl("originalUrl"))
                .thenReturn(Optional.empty());
        when(urlRepository.save(any()))
                .thenReturn(urlMock);

        var result = urlService.shortUrl(URL_MOCK);
        assertNotNull(result);
        assertNotNull(result.getShortUrl());
        assertNotNull(result.getId());
        assertEquals(URL_MOCK, result.getOriginalUrl());

        verify(urlRepository).save(any());
        verify(urlRepository).findByOriginalUrl(any());
    }
}

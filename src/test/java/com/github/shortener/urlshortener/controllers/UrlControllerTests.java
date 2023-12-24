package com.github.shortener.urlshortener.controllers;

import com.github.shortener.urlshortener.domains.Url;
import com.github.shortener.urlshortener.dtos.UrlDto;
import com.github.shortener.urlshortener.exceptions.errors.StandardUrlAlreadyExistsException;
import com.github.shortener.urlshortener.services.UrlService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UrlController.class)
class UrlControllerTests {

    private final static String URL_MOCK = "/url/short";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UrlService urlService;

    @Test
    void shouldReturnTheCorrectlyShortUrl() throws Exception {
        when(urlService.shortUrl(anyString()))
                .thenReturn(urlMock());

        mockMvc.perform(MockMvcRequestBuilders.post(URL_MOCK)
                        .param("url", "TEST"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void shouldNOtReturnTheCorrectlyShortUrl() throws Exception {
        when(urlService.shortUrl(anyString()))
                .thenThrow(new StandardUrlAlreadyExistsException("test"));

        mockMvc.perform(MockMvcRequestBuilders.post(URL_MOCK)
                        .param("url", "TEST"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    private UrlDto urlMock() {
        return new UrlDto( "orginalUrl", "shortUrl");
    }
}

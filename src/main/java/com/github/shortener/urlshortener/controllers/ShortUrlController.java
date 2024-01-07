package com.github.shortener.urlshortener.controllers;

import com.github.shortener.urlshortener.dtos.UrlDto;
import com.github.shortener.urlshortener.services.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/short")
public class ShortUrlController {

    private final UrlService urlService;

    @PostMapping("/{shortUrl}")
    public ResponseEntity<UrlDto> shortAnUrl(@PathVariable String shortUrl) {
        return ResponseEntity.status(CREATED)
                .body(urlService.shortUrl(shortUrl));
    }
}

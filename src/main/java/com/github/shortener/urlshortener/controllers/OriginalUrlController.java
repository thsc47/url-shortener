package com.github.shortener.urlshortener.controllers;

import com.github.shortener.urlshortener.dtos.UrlDto;
import com.github.shortener.urlshortener.services.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class OriginalUrlController {

    private final UrlService urlService;

    @GetMapping("/{shortUrl}")
    public ResponseEntity<UrlDto> shortAnUrl(@PathVariable String shortUrl) {
        return ResponseEntity.status(OK)
                .body(urlService.getOriginalUrl(shortUrl));
    }
}

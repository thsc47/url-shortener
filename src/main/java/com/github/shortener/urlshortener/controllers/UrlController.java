package com.github.shortener.urlshortener.controllers;

import com.github.shortener.urlshortener.domains.Url;
import com.github.shortener.urlshortener.services.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/url")
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/short")
    public ResponseEntity<Url> shortAnUrl(@RequestParam String url) {
        return ResponseEntity.status(CREATED)
                .body(urlService.shortUrl(url));
    }

}

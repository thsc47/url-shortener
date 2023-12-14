package com.github.shortener.urlshortener.controllers;

import com.github.shortener.urlshortener.services.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/url")
public class UrlController {

    private final UrlService urlService;

    @PatchMapping("/short")
    public ResponseEntity<String> shortAnUrl(@RequestParam String url) {
        return Optional.of(urlService.shortUrl(url))
                .map(ResponseEntity::ok)
                .orElseThrow(RuntimeException::new);
    }

}

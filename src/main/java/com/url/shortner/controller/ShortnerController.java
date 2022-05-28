package com.url.shortner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/short")
public class ShortnerController {

    @PostMapping
    public ResponseEntity<String> shortUrl(@RequestParam String url){
        return ResponseEntity.ok().body(url);
    }
}

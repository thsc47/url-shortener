package com.url.shortner.controller;

import com.url.shortner.service.Impl.ShortnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/short")
public class ShortnerController {

    @Autowired
    ShortnerServiceImpl shortnerServiceImpl;

    @PostMapping
    public ResponseEntity shortUrl(@RequestParam String url){
        shortnerServiceImpl.shortUrl(url);
        return ResponseEntity.ok().build();
    }
}

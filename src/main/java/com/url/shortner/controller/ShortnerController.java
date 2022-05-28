package com.url.shortner.controller;

import com.url.shortner.representer.ShortUrlRepresenter;
import com.url.shortner.service.Impl.ShortnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.url.shortner.mapper.ShortUrlMapper.toRepresenter;

@RestController
@RequestMapping("/short")
public class ShortnerController {

    @Autowired
    ShortnerServiceImpl shortnerServiceImpl;

    @PostMapping
    public ResponseEntity<ShortUrlRepresenter> shortUrl(@RequestParam String url){
        return ResponseEntity.ok().body(toRepresenter(shortnerServiceImpl.shortUrl(url)));
    }
}

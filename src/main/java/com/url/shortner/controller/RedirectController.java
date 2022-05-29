package com.url.shortner.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class RedirectController {
    @Autowired
    HttpServletResponse httpServletResponse;

    @GetMapping("/{key}")
    public void redirectToTrueURL(@PathVariable String key){
        httpServletResponse.setHeader("Location", "https://www.google.com/");
        httpServletResponse.setStatus(HttpStatus.PERMANENT_REDIRECT.value());
        //return key;
    }
}

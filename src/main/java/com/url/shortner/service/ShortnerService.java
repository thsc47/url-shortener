package com.url.shortner.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ShortnerService {

    public String shortUrl(String url) {

    }

    private String generateASalt() {
        final String SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        while (salt.length() < 8) {
            Random random = new Random();
            int randomIndex = random.nextInt() * SALTCHARS.length();
            salt.append(SALTCHARS.charAt(randomIndex));
        }
        return String.valueOf(salt);
    }
}

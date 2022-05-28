package com.url.shortner.service;

import com.url.shortner.domain.ShortUrl;
import com.url.shortner.repository.ShortnerUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class ShortnerService {

    @Autowired
    ShortnerUrlRepository shortnerUrlRepository;

    public String shortUrl(String url) {
        Optional<ShortUrl> optionalShortUrl = shortnerUrlRepository.findByUrl(url);
        if(optionalShortUrl.isEmpty())
            return "vazia";
       return null;
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

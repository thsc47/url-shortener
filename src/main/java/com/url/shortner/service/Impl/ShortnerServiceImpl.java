package com.url.shortner.service.Impl;

import com.url.shortner.domain.ShortUrl;
import com.url.shortner.repository.ShortnerUrlRepository;
import com.url.shortner.service.ShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

import static com.url.shortner.mapper.ShortUrlMapper.toDomain;

@Service
public class ShortnerServiceImpl implements ShortnerService {

    @Autowired
    ShortnerUrlRepository shortnerUrlRepository;
    @Override
    public ShortUrl shortUrl(String url) {
        Optional<ShortUrl> optionalShortUrl = shortnerUrlRepository.findByUrl(url);
        if(optionalShortUrl.isEmpty())
            return shortnerUrlRepository.save(toDomain(url));
        return shortnerUrlRepository.save(toDomain(url));
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

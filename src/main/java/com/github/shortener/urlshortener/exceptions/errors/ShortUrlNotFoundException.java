package com.github.shortener.urlshortener.exceptions.errors;

public class ShortUrlNotFoundException extends RuntimeException {

    public ShortUrlNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

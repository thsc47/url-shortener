package com.github.shortener.urlshortener.exceptions.errors;

public class StandardUrlNotFoundException extends RuntimeException {

    public StandardUrlNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

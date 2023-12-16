package com.github.shortener.urlshortener.exceptions.errors;

import static java.lang.String.format;

public class StandardUrlAlreadyExistsException extends RuntimeException {

    public StandardUrlAlreadyExistsException(String errorMessage) {
        super(format("url %s already has a short url", errorMessage));
    }
}

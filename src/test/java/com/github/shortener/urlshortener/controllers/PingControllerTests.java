package com.github.shortener.urlshortener.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PingControllerTests {

    @InjectMocks
    PingController pingController;

    @Test
    void shouldReturnPong() {
        var result = pingController.returnPong().getBody();
        assertEquals("pong", result);
    }
}

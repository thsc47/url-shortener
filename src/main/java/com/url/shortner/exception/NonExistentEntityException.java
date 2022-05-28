package com.url.shortner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NonExistentEntityException extends RuntimeException{
     public NonExistentEntityException(){
         super("Not Found");
     }
}

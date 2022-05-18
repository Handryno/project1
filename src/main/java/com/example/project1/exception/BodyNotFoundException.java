package com.example.project1.exception;

import feign.FeignException;

public class BodyNotFoundException extends FeignException {
    public BodyNotFoundException(){
        super(404,"Response Body Not Found");
    }
}

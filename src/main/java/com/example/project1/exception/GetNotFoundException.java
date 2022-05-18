package com.example.project1.exception;

import com.example.project1.dto.GetDataPokemonApi;

public class GetNotFoundException extends Exception{
    public GetNotFoundException(String message){
        super(message);
    }

}

package com.example.project1.config;

import com.example.project1.dto.BaseResponse;
import com.example.project1.dto.GetDataPokemonApi;
import com.example.project1.exception.BodyNotFoundException;
import com.example.project1.exception.DataNotFoundException;
import com.example.project1.exception.GetNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.internal.LinkedTreeMap;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

@Slf4j
public class PokemonDecoder implements ErrorDecoder {
    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String name, Response response){


        switch (response.status()) {
            case 404:
                return new GetNotFoundException("Not Found");
            default:
                return errorDecoder.decode(name, response);
        }
    }


}

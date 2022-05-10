package com.example.project1.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.internal.LinkedTreeMap;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;

@Slf4j
public class PokemonDecoder implements Decoder{
    @Override
    public Object decode (Response response, Type type) throws IOException {
        log.info("RESPONSE : {} - {}", response, response.body());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body().asReader(), LinkedTreeMap.class);

    }
}
package com.example.project1.config;

import com.example.project1.exception.BodyNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.internal.LinkedTreeMap;
import feign.Response;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;

@Slf4j
public class SampleDecoder implements Decoder {
    @Override
    public Object decode (Response response, Type type) throws IOException {
        if (response.body() == null || response.body().toString().equals("")) {
            throw new BodyNotFoundException();
        }
        log.info("RESPONSE : {} - {}", response, response.body());

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response.body().asReader(), LinkedTreeMap.class);

    }
}

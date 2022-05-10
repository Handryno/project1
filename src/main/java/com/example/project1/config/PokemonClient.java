package com.example.project1.config;


import com.google.gson.internal.LinkedTreeMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PostConstruct;


@FeignClient(name = "switching-client",url = "https://pokeapi.co/api/v2/pokemon", configuration = PokemonConfiguration.class)
public interface PokemonClient {
    @GetMapping(value="/{pokemon_name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    LinkedTreeMap getDataByGet(@PathVariable String pokemon_name);


}

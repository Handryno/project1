package com.example.project1.config;

import com.google.gson.internal.LinkedTreeMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://pokeapi.co/api/v2/pokemon", name = "POKEMON-CLIENT")
public interface PokemonClient {
//    @GetMapping(value = "/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    LinkedTreeMap getDataByGet(@PathVariable String name);

    @GetMapping(value = "/pikachu", consumes = MediaType.APPLICATION_JSON_VALUE)
    LinkedTreeMap getDataByGet();
}

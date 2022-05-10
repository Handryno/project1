package com.example.project1.controller;

import com.example.project1.dto.AddDataPokemonRequest;
import com.example.project1.dto.BaseResponse;
import com.example.project1.service.PokemonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v2/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse addData(@RequestBody AddDataPokemonRequest request){
        return  pokemonService.addData(request);
    }

    @GetMapping(value = "/get/{pokemon_name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse pokemonGet(@PathVariable String pokemon_name){
        return pokemonService.testPokemonGet(pokemon_name);
    }

}

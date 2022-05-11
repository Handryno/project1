package com.example.project1.controller;

import com.example.project1.config.PokemonClient;
import com.example.project1.dto.AddDataPokemonRequest;
import com.example.project1.dto.BaseResponse;
import com.example.project1.service.PokemonService;
import com.google.gson.internal.LinkedTreeMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pokemon")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    private final PokemonClient pokemonClient;

//    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public BaseResponse addData(@RequestBody AddDataPokemonRequest request){
//        return  pokemonService.addData(request);
//    }

//    @GetMapping(value = "/get/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public BaseResponse pokemonGet(@PathVariable String name){
//        return pokemonService.testPokemonGet(name);
//    }
    @GetMapping("/get/pikachu")
    public BaseResponse pokemonGetPikachu(){
        return pokemonService.testPokemonGet();
    }

}

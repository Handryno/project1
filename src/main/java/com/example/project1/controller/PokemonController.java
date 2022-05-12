package com.example.project1.controller;

import com.example.project1.dto.*;
import com.example.project1.service.PokemonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;


    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse addData(@RequestBody AddDataPokemonRequest request){
        return  pokemonService.addData(request);
    }
    @PostMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse getData(@RequestBody GetDataPokemonRequest request){
        return pokemonService.getDataByName(request);
    }
    @GetMapping(value = "/get/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse pokemonGet(@PathVariable String name){
        return pokemonService.testPokemonGet(name);
    }

    @PostMapping(value = "/cek-kuat", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse cekSiapaKuatPokemon(@RequestBody CekRequestKuat request){
        return pokemonService.cekSiapaKuat(request);
    }

    @PostMapping(value = "/cek-lemah", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse cekSiapaLemah(@RequestBody CekRequestLemah request){
        return pokemonService.cekSiapaLemah(request);
    }

}

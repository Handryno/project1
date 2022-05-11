package com.example.project1.service;

import com.example.project1.config.PokemonClient;
import com.example.project1.dto.AddDataPokemonRequest;
import com.example.project1.dto.BaseResponse;
import com.example.project1.entity.Pokemon;
import com.example.project1.repository.PokemonRepository;
import com.example.project1.util.ResponseUtil;
import com.google.gson.internal.LinkedTreeMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Service
public class PokemonService {
    @Autowired
    private PokemonClient pokemonClient;
    @Autowired
    private PokemonRepository pokemonRepository;

    @Transactional
    public BaseResponse addData(AddDataPokemonRequest request){
        log.info("Start service addData Pokemon");
        Pokemon pokemon = new Pokemon();
        pokemon.setId(System.currentTimeMillis());
        pokemon.setName(request.getName());
        pokemon.setBase_experience(request.getBase_experience());
        pokemon.setWeight(request.getWeight());
        pokemon.setHeight(request.getHeight());
        pokemonRepository.save(pokemon);

        return ResponseUtil.setResponse("Success", pokemon);
    }

//    public BaseResponse testPokemonGet(String name){
//        log.info("Start Service testPokemonGet");
//        LinkedTreeMap res = pokemonClient.getDataByGet(name);
//        if (res.isEmpty()){
//            return ResponseUtil.setResponse("Failed", "Data tidak ditemukan");
//        }
//        return ResponseUtil.setResponse("Success", res.get("data"));
//    }
    public BaseResponse testPokemonGet(){
        log.info("Start Service testPokemonGet");
        LinkedTreeMap response = pokemonClient.getDataByGet();
//        if (res.isEmpty()){
//            return ResponseUtil.setResponse("Failed", "Data tidak ditemukan");
//        }
        return ResponseUtil.setResponse("Success", response.get("data"));
    }
}

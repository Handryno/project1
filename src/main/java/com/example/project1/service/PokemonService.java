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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class PokemonService {
    private final PokemonClient pokemonClient;
    private final PokemonRepository pokemonRepository;

    @Transactional
    public BaseResponse addData(AddDataPokemonRequest request){
        log.info("Start service addData Pokemon");
        Pokemon pokemon = new Pokemon();
        pokemon.setId(System.currentTimeMillis());
        pokemon.setPokemon_name(request.getPokemon_name());
        pokemon.setBase_exp(request.getBase_exp());
        pokemon.setWeight(request.getPokemon_name());
        pokemon.setHeight(request.getHeight());
        pokemonRepository.save(pokemon);

        return ResponseUtil.setResponse("Success", pokemon);
    }

    public BaseResponse testPokemonGet(String pokemon_name){
        log.info("Start Service testPokemonGet");
        LinkedTreeMap response = pokemonClient.getDataByGet(pokemon_name);
        if (response.get("status").toString().equals("00")){
            return ResponseUtil.setResponse("Success", response.get("data"));
        }
        return ResponseUtil.setResponse("Failed", "data not found");
    }
}

package com.example.project1.service;

//import com.example.project1.config.PokemonClient;
import com.example.project1.config.PokemonClient;
import com.example.project1.dto.BaseResponse;
import com.example.project1.repository.PokemonRepository;
import com.example.project1.util.ResponseUtil;
import com.google.gson.internal.LinkedTreeMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PokemonService {
    private final PokemonClient pokemonClient;

    private final PokemonRepository pokemonRepository;

//    @Transactional
//    public BaseResponse testPokemonGet(String pokemon_name){
//        log.info("Start service testPokemonGet");
//        LinkedTreeMap response = pokemonClient.getDataByGet(pokemon_name);
//        if(response.get("status").toString().equals("00")){
//            return ResponseUtil.setResponse("success", response.get("data"));
//        }
//        return ResponseUtil.setResponse("failed", "data not found");
//    }
}

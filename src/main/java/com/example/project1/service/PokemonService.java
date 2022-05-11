package com.example.project1.service;

import com.example.project1.config.PokemonClient;
import com.example.project1.dto.*;
import com.example.project1.entity.Pokemon;
import com.example.project1.repository.PokemonRepository;
import com.example.project1.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Service
public class PokemonService {

    private final PokemonClient pokemonClient;

    private final PokemonRepository pokemonRepository;

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

    public BaseResponse getDataByName(GetDataPokemonRequest request){
        log.info("Start service getDataByName");
        GetDataPokemonResponse response = new GetDataPokemonResponse();

        Pokemon pokemon = pokemonRepository.findPokemonByName(request.getName());
        if (pokemon == null){
            ResponseUtil.setResponse("Failed", "Data tidak ditemukan");
        }
        response.setName(pokemon.getName());
        response.setBase_experience(pokemon.getBase_experience());
        response.setWeight(pokemon.getWeight());
        response.setHeight(pokemon.getHeight());

        return ResponseUtil.setResponse("Success", response);
    }

    public BaseResponse cekSiapaKuat(CekSiapaKuatRequest request){
        log.info("Start service cekSiapaKuat");
        CekSiapaKuatResponse response = new CekSiapaKuatResponse();
        Pokemon pokemon = pokemonRepository.findPokemonByNameOrNameAndType()
    }

    public BaseResponse testPokemonGet(String name){
        log.info("Start Service testPokemonGet");
        GetDataPokemonApi response = pokemonClient.getDataByGet(name);

//        if (response == null){
//            return ResponseUtil.setResponse("Success", response);
//        }
        return ResponseUtil.setResponse("Success", response);
    }
}

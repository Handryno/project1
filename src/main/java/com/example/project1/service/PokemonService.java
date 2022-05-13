package com.example.project1.service;

import com.example.project1.config.PokemonClient;
import com.example.project1.dto.*;
import com.example.project1.entity.Pokemon;
import com.example.project1.repository.PokemonRepository;
import com.example.project1.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    public BaseResponse cekSiapaKuat(CekRequestKuat request){
        log.info("Start service cekSiapaKuat");
        CekResponseKuat response = new CekResponseKuat();
        Pokemon pokemon1 = pokemonRepository.findPokemonByName(request.getName1());
        Pokemon pokemon2 = pokemonRepository.findPokemonByName(request.getName2());
        if (pokemon1 == null && pokemon2 == null){
            ResponseUtil.setResponse("Failed", "Data tidak ditemukan");
        }
        pokemon1.setName(request.getName1());
        pokemon2.setName(request.getName2());
        switch(request.getType()){
            case 1:
                int p1 = Integer.parseInt(pokemon1.getBase_experience());
                int p2 = Integer.parseInt(pokemon2.getBase_experience());
                if (p1 < p2){
                    response.setWinner(pokemon2.getName());
                    response.setPower(pokemon2.getBase_experience());
                }else if ( p1 > p2){
                    response.setWinner(pokemon1.getName());
                    response.setPower(pokemon1.getBase_experience());
                }else{
                    log.info("Draw");
                }
                break;
            case 2:
                int h1 = Integer.parseInt(pokemon1.getHeight());
                int h2 = Integer.parseInt(pokemon2.getHeight());
                if(h1 > h2){
                    response.setWinner(pokemon1.getName());
                    response.setPower(pokemon1.getHeight());
                }else if(h2 > h1){
                    response.setWinner(pokemon2.getName());
                    response.setPower(pokemon2.getHeight());
                }else{
                    log.info("Draw");
                }
                break;
            case 3:
                int w1 = Integer.parseInt(pokemon1.getWeight());
                int w2 = Integer.parseInt(pokemon2.getWeight());
                if (w1 > w2){
                    response.setWinner(pokemon1.getName());
                    response.setPower(pokemon1.getWeight());
                }else if (w2 > w1){
                    response.setWinner(pokemon2.getName());
                    response.setPower(pokemon2.getWeight());
                }else{
                    log.info("Draw");
                }
                break;
        }
        return ResponseUtil.setResponse("Success", response);
    }

    public BaseResponse cekSiapaLemah(CekRequestLemah request){
        log.info("Start service cekSiapaKuat");
        CekResponseLemah response = new CekResponseLemah();
        Pokemon pokemon1 = pokemonRepository.findPokemonByName(request.getName1());
        Pokemon pokemon2 = pokemonRepository.findPokemonByName(request.getName2());
        if (pokemon1 == null && pokemon2 == null){
            ResponseUtil.setResponse("Failed", "Data tidak ditemukan");
        }
        pokemon1.setName(request.getName1());
        pokemon2.setName(request.getName2());
        switch(request.getType()){
            case 1:
                int p1 = Integer.parseInt(pokemon1.getBase_experience());
                int p2 = Integer.parseInt(pokemon2.getBase_experience());
                if (p1 > p2){
                    response.setLooser(pokemon2.getName());
                    response.setPower(pokemon2.getBase_experience());
                }else if ( p1 < p2){
                    response.setLooser(pokemon1.getName());
                    response.setLooser(pokemon1.getBase_experience());
                }else{
                    log.info("Draw");
                }
                break;
            case 2:
                int h1 = Integer.parseInt(pokemon1.getHeight());
                int h2 = Integer.parseInt(pokemon2.getHeight());
                if(h1 < h2){
                    response.setLooser(pokemon1.getName());
                    response.setPower(pokemon1.getHeight());
                }else if(h2 < h1){
                    response.setLooser(pokemon2.getName());
                    response.setPower(pokemon2.getHeight());
                }else{
                    log.info("Draw");
                }
                break;
            case 3:
                int w1 = Integer.parseInt(pokemon1.getWeight());
                int w2 = Integer.parseInt(pokemon2.getWeight());
                if (w1 < w2){
                    response.setLooser(pokemon1.getName());
                    response.setPower(pokemon1.getWeight());
                }else if (w2 < w1){
                    response.setLooser(pokemon2.getName());
                    response.setPower(pokemon2.getWeight());
                }else{
                    log.info("Draw");
                }
                break;
        }
        return ResponseUtil.setResponse("Success", response);
    }

    public BaseResponse testPokemonGet(String name){
        log.info("Start Service testPokemonGet");
        GetDataPokemonApi response = pokemonClient.getDataByGet(name);

        if (response == null){
            return ResponseUtil.setResponse("Failed", response);
        }
        return ResponseUtil.setResponse("Success", response);
    }
}

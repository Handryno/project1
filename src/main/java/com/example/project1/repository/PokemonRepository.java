package com.example.project1.repository;

import com.example.project1.entity.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PokemonRepository extends MongoRepository <Pokemon, String> {

}

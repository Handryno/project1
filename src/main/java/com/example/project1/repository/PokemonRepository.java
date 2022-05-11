package com.example.project1.repository;

import com.example.project1.entity.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends MongoRepository<Pokemon, String> {
//     Pokemon findPokemonByPokemon_name(String name);
}

package com.example.project1.repository;

import com.example.project1.entity.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends MongoRepository<Pokemon, String> {
     Pokemon findPokemonByName(String name);

     Pokemon findPokemonByNameOrNameAndType(String name1, String name2, int type);
}

package com.example.project1.config;

import org.springframework.context.annotation.Bean;

public class PokemonConfiguration {

    @Bean
    public PokemonDecoder decoder(){return new PokemonDecoder();}

    @Bean
    public PokemonInterceptor interceptor(){return new PokemonInterceptor();}
}

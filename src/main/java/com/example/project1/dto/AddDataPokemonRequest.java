package com.example.project1.dto;

import lombok.Data;

@Data
public class AddDataPokemonRequest {
    private String pokemon_name;
    private String base_exp;
    private String height;
    private String weight;
}

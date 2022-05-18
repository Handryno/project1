package com.example.project1.dto;

import lombok.Data;

@Data
public class AddDataPokemonRequest {
    private String name;
    private String base_experience;
    private String height;
    private String weight;
}

package com.example.project1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetDataPokemonResponse {
    @JsonProperty("name")
    private String name;

    @JsonProperty("base_experience")
    private String base_experience;

    @JsonProperty("height")
    private String height;

    @JsonProperty("weight")
    private String weight;
}

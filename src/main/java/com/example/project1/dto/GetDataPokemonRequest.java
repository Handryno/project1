package com.example.project1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetDataPokemonRequest {
    @JsonProperty("name")
    private String name;
}

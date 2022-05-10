package com.example.project1.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pokemon")
public class Pokemon {
    @Id
    private Long id;
    private String pokemon_name;
    private String base_exp;
    private String height;
    private String weight;
}

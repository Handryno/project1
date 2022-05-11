package com.example.project1.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Pokemon")
public class Pokemon {
    @Id
    private Long id;
    private String name;
    private String base_experience;
    private String height;
    private String weight;
}

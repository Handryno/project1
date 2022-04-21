package com.example.project1.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tbl_sample")
@Data
public class TblSample {

    @Id
    private Long id;
    private String name;
    private String address;
    private String gender;
    private Date dob;
    private Date createDate;
    private Date updateDate;
}

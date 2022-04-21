package com.example.project1.repository;

import com.example.project1.entity.TblSample;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SampleRepository extends MongoRepository<TblSample, String> {
    TblSample findByNameAndDob(String name, String dob);
}

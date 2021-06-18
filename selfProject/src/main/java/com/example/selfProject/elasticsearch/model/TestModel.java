package com.example.selfProject.elasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "test")
public class TestModel {
    @Id
    private Long id;
}

package com.example.selfProject.elasticsearch.repository;

import com.example.selfProject.elasticsearch.model.TestModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<TestModel,Long> {

}

package com.example.selfProject.service.impl;

import com.example.selfProject.elasticsearch.model.TestModel;
import com.example.selfProject.elasticsearch.repository.ProductRepository;
import com.example.selfProject.service.ElasticTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElasticTestServiceImpl implements ElasticTestService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public void addTest() {
        TestModel testModel=new TestModel();
        testModel.setId(999L);
        productRepository.save(testModel);
    }
}

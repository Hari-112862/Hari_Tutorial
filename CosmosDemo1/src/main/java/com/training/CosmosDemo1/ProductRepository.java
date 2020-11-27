package com.training.CosmosDemo1;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;

@Repository
public interface ProductRepository extends CosmosRepository<Product, String> {
    List findByProductName(String productName);
 
}
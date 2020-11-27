package com.training.CosmosDemo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.azure.data.cosmos.PartitionKey;

@SpringBootTest
public class AzureCosmosDbApplicationManualTest {
 
    @Autowired
    ProductRepository productRepository;
 
    @Test
    public void givenProductIsCreated_whenCallFindById_thenProductIsFound() {
        Product product = new Product();
        product.setProductid("1001");
        product.setProductCategory("Shirt");
        product.setPrice(110.0);
  product.setProductName("Blue Shirt");
 
        productRepository.save(product);
        Product retrievedProduct = productRepository.findById("1001", new PartitionKey("Shirt"))
            .orElse(null);
        Assert.notNull(retrievedProduct, "Retrieved Product is Null");
    }
    
    
}
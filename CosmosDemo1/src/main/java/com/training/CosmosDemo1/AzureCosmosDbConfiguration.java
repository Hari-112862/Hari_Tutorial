package com.training.CosmosDemo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.data.cosmos.CosmosKeyCredential;
import com.microsoft.azure.spring.data.cosmosdb.config.AbstractCosmosConfiguration;
import com.microsoft.azure.spring.data.cosmosdb.config.CosmosDBConfig;
import com.microsoft.azure.spring.data.cosmosdb.repository.config.EnableCosmosRepositories;

@Configuration
@EnableCosmosRepositories(basePackages = "com.training.CosmosDemo1")
public class AzureCosmosDbConfiguration extends AbstractCosmosConfiguration {
 
    @Value("${azure.cosmosdb.uri}")
    private String uri;
 
    @Value("${azure.cosmosdb.key}")
    private String key;
 
    @Value("${azure.cosmosdb.database}")
    private String dbName;
 
    private CosmosKeyCredential cosmosKeyCredential;
 
    @Bean
    public CosmosDBConfig getConfig() {
        this.cosmosKeyCredential = new CosmosKeyCredential(key);
        CosmosDBConfig cosmosdbConfig = CosmosDBConfig.builder(uri, this.cosmosKeyCredential, dbName)
            .build();
        return cosmosdbConfig;
        
    }
    
}

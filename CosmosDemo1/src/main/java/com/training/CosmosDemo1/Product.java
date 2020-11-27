package com.training.CosmosDemo1;

import org.springframework.data.annotation.Id;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

@Document(collection = "products")
public class Product {
 
    @Id
    private String productid;
 
    private String productName;
 
    private double price;
 
    @PartitionKey
    private String productCategory;

	public void setProductid(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setProductCategory(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setPrice(double d) {
		// TODO Auto-generated method stub
		
	}

	public void setProductName(String string) {
		// TODO Auto-generated method stub
		
	}
}

package com.training.CosmosDemo;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Optional;

@SpringBootApplication
public class CosmosDemoApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CosmosDemoApplication.class);

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(CosmosDemoApplication.class, args);
    }

    public void run(String... var1) throws Exception {
    	
        final User testUser = new User("1", "Ram", "Bala", "4567 Main St Chrompet, Chennai 600044");

        LOGGER.info("Saving user: {}", testUser);

        // Save the User class to Azure CosmosDB database.
        final Mono<User> saveUserMono = repository.save(testUser);
        
    //  Nothing happens until we subscribe to these Monos.
        final User savedUser = saveUserMono.block();
        LOGGER.info("Saved user");
               
        
        final Mono<User> findByIdMono = repository.findById(testUser.getId());
        final User findByIdUser = findByIdMono.block();
        
        System.out.println("User name: "+findByIdUser.getFirstName());
        

        

        
    }

    @PostConstruct
    public void setup() {
        LOGGER.info("Clear the database");
        this.repository.deleteAll().block();
    }

    @PreDestroy
    public void cleanup() {
        LOGGER.info("Cleaning up users");
        this.repository.deleteAll().block();
    }
}
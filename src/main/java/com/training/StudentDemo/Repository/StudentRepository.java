
/**
 * Project Name  : StudentProject

 * 
 */


package com.training.StudentDemo.Repository;



import org.springframework.stereotype.Repository;


import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;
import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.training.StudentDemo.Model.Student;

import reactor.core.publisher.Flux;

/***
 * Interface for student repository
 * @author SACHIN AJITHKUMAR
 *
 */
@Repository
public interface StudentRepository extends ReactiveCosmosRepository<Student, String> {
 
	Flux<Student> findByFirstName(String firstName);

}
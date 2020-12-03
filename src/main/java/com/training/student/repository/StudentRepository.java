/***
 * Project Name  : StudentProject
 */
package com.training.student.repository;

import org.springframework.stereotype.Repository;
import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.training.student.model.Student;


/***
 * Interface for student repository
 * @author SACHIN AJITHKUMAR
 *
 */
@Repository
public interface StudentRepository extends ReactiveCosmosRepository<Student, String> {
 


}
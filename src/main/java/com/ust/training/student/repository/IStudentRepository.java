/***
 * Project Name  : StudentProject
 */
package com.ust.training.student.repository;

import org.springframework.stereotype.Repository;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.ust.training.student.model.Student;
/***
 * Interface for student repository
 * @author SACHIN AJITHKUMAR
 *
 */
@Repository
public interface IStudentRepository extends ReactiveCosmosRepository<Student, String> {
}
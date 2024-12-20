package com.example.demo.Repository;

import com.example.demo.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findByEmailAndPassword(String email, String password);
}

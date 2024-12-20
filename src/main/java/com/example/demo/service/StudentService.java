package com.example.demo.service;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepo;

    public List<Student> getAllStudents() {
        List<Student> result = (List<Student>) studentRepo.findAll();
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Student>();
        }
    }

    public Student findByEmailAndPassword(String email, String password){
        return studentRepo.findByEmailAndPassword(email, password);
    }
}

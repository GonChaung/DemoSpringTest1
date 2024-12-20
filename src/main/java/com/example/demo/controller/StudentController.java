package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    StudentService service;

    @RequestMapping("/students")
    public String student(Model model){
        List<Student> students = service.getAllStudents();
        model.addAttribute("students", students);
        return "Student";
    }
}

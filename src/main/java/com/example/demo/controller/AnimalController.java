package com.example.demo.controller;

import com.example.demo.model.Animal;
import com.example.demo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class AnimalController {
    @Autowired
    AnimalService service;
    @GetMapping("/animals")
    public String animal(Model model) {
        List<Animal> animals=service.getAllAnimals();
        model.addAttribute("animals", animals);
        return "Animal";
    }

}

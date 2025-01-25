package com.example.demo.controller;

import com.example.demo.model.Animal;
import com.example.demo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    AnimalService animalService;
    @GetMapping("")
    public String animal(Model model) {
        List<Animal> animals=animalService.getAllAnimals();
        model.addAttribute("animals", animals);
        return "Animal";
    }
    @GetMapping("/update/{id}")
    public String updateAnimalForm(@PathVariable Long id, Model model) {
        Animal animal=new Animal("See","Cat",13);
        animalService.updateAnimalById(id,animal);
        model.addAttribute("animal", animal);
        return "Animal";
    }

    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return "redirect:/animals";
    }
}

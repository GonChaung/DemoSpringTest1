//package com.example.demo.controller;
//
//import com.example.demo.model.Animal;
//import com.example.demo.service.AnimalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/animals")
//public class AnimalController {
//
//    @Autowired
//    private AnimalService animalService;
//
//    // Retrieve all animals
//    @GetMapping
//    public ResponseEntity<List<Animal>> getAllAnimals() {
//        List<Animal> animals = animalService.getAllAnimals();
//        return ResponseEntity.ok(animals);
//    }
//
//    // Update an animal by ID
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
//        Animal updatedAnimal = animalService.updateAnimalById(id, animal);
//        return ResponseEntity.ok(updatedAnimal);
//    }
//
//    // Delete an animal by ID
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteAnimal(@PathVariable Long id) {
//        animalService.deleteAnimal(id);
//        return ResponseEntity.ok("Animal with ID " + id + " has been deleted.");
//    }
//}
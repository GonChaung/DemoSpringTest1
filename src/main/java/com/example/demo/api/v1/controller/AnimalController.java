package com.example.demo.api.v1.controller;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.model.Animal;
import com.example.demo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalController {
   //changes by felix
    @Autowired
    private AnimalService animalService;

    // Retrieve all animals
    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> animals = animalService.getAllAnimals();
        return ResponseEntity.ok(animals);
    }

    // Update an animal by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        Animal updatedAnimal = null;
        try {
            updatedAnimal = animalService.updateAnimalById(id, animal);
        } catch (NotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(Map.of("error", "Animal with ID " + id + " not found."));
        }
        return ResponseEntity.ok(updatedAnimal);
    }

    // Delete an animal by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.ok("Animal with ID " + id + " has been deleted.");
    }
}
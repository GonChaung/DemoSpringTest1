package com.example.demo.service;

import com.example.demo.Repository.AnimalRepository;
import com.example.demo.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository repository;

    public List<Animal> getAllAnimals()
    {
        List<Animal> result = (List<Animal>) repository.findAll();
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Animal>();
        }
    }
}

package com.example.demo.service;

import com.example.demo.Repository.AnimalRepository;
import com.example.demo.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;
    public List<Animal> getAllAnimals()
    {
        List<Animal> result = (List<Animal>) animalRepository.getAllAnimalByNative();
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Animal>();
        }
    }
    public void updateAnimalById(long id,Animal animal){
        animalRepository.updateAnimalById(id,animal.getName(),animal.getType(),animal.getAge());
    }
    @Transactional
    public void deleteAnimal(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new IllegalArgumentException("Animal with id " + id + " does not exist.");
        }
        animalRepository.deleteById(id);
    }
}

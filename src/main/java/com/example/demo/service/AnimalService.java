package com.example.demo.service;

import com.example.demo.Exception.NotFoundException;
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
        List<Animal> animals = (List<Animal>) animalRepository.getAllAnimalByNative();
        if(animals.size() > 0) {
            return animals;
        } else {
            return new ArrayList<Animal>();
        }
    }
    public Animal updateAnimalById(long id, Animal animal) throws NotFoundException {
        int flag=animalRepository.updateAnimalById(id,animal.getName(),animal.getType(),animal.getAge());
        if(flag==0){
            throw new NotFoundException("animal not found in database!!");
        }
        System.out.println("flag=="+flag);
        Animal updatedAnimal=animalRepository.getAnimalById(id);
        return updatedAnimal;
    }
    @Transactional
    public void deleteAnimal(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new IllegalArgumentException("Animal with id " + id + " does not exist.");
        }
        animalRepository.deleteById(id);
    }
}

package com.example.demo.Repository;

import com.example.demo.model.Animal;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
    @Query(value="select * from animal", nativeQuery=true)
    List<Animal> getAllAnimalByNative();

    @Modifying
    @Transactional
    @Query(value = "UPDATE animal SET name = :name, type = :type, age = :age WHERE id = :id", nativeQuery = true)
    void updateAnimalById(@Param("id") Long id,
                          @Param("name") String name,
                          @Param("type") String type,
                          @Param("age") Integer age);


}

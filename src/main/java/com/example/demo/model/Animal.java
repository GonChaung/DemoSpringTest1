package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="animal")
public class Animal {
    @Id
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="type")
    private String type;
    @Column(name="age")
    private int age;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id",
            nullable = false,
            referencedColumnName = "id")
    @JsonManagedReference// Foreign key column
    private Category category;

    public Animal(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public Animal() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

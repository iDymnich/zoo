package com.abunko.zoo.service.role;

import java.util.Collection;

import com.abunko.zoo.model.Animal;

public interface Role {
    Collection<Animal> showPets();
    Collection<Animal> buyPet(Animal animal);
    Collection<Animal> sellPet(String name);
}

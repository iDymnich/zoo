package com.abunko.zoo.repository;

import java.util.Collection;

import com.abunko.zoo.model.Animal;

public interface PetsContainer {
    Collection<Animal> getAnimals();
    Collection<Animal> addAnimal(Animal animal);
    Collection<Animal> removeAnimal(String name);
}

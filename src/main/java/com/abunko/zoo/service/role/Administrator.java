package com.abunko.zoo.service.role;

import java.util.Collection;

import com.abunko.zoo.repository.PetsContainer;
import com.abunko.zoo.model.Animal;

public class Administrator extends AbstractRole {


    Administrator(boolean isZooWorks, PetsContainer petsContainer) {
        super(isZooWorks, petsContainer);
    }

    @Override
    public Collection<Animal> showPets() {
        return getAccessToPets().getAnimals();
    }

    @Override
    public Collection<Animal> buyPet(Animal animal) {
        return getAccessToPets().addAnimal(animal);
    }

    @Override
    public Collection<Animal> sellPet(String name) {
        return getAccessToPets().removeAnimal(name);
    }
}

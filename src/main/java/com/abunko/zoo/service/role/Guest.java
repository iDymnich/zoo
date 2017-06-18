package com.abunko.zoo.service.role;

import java.util.Collection;

import com.abunko.zoo.model.Animal;
import com.abunko.zoo.repository.PetsContainer;

public class Guest extends AbstractRole {

    Guest(boolean isZooWorks, PetsContainer petsContainer) {
        super(isZooWorks, petsContainer);
    }

    @Override
    public Collection<Animal> showPets() {
        return getAccessToPets().getAnimals();
    }

    @Override
    public Collection<Animal> buyPet(Animal animal) {
        throw new IllegalStateException("Guest has not permissions to buy pets");
    }

    @Override
    public Collection<Animal> sellPet(String name) {
        throw new IllegalStateException("Guest has not permissions to sell pets");
    }
}

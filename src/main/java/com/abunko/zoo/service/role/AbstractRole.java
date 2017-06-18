package com.abunko.zoo.service.role;

import com.abunko.zoo.repository.PetsContainer;

public abstract class AbstractRole implements Role {
    private final boolean isZooWorks;
    private final PetsContainer petsContainer;

    protected AbstractRole(boolean isZooWorks, PetsContainer petsContainer) {
        this.isZooWorks = isZooWorks;
        this.petsContainer = petsContainer;
    }

    protected PetsContainer getAccessToPets() {
        if (isZooWorks) return petsContainer;
        throw new IllegalStateException("Zoo does not works today! Maybe weekends ?");
    }
}

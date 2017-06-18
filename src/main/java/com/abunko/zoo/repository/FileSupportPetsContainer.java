package com.abunko.zoo.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import com.abunko.zoo.model.Animal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.nio.file.StandardOpenOption.WRITE;

public class FileSupportPetsContainer implements PetsContainer {

    private final Path filePath;
    private final ObjectMapper objectMapper;

    public FileSupportPetsContainer(String filePath, ObjectMapper objectMapper) {
        this.filePath = Paths.get(filePath);
        this.objectMapper = objectMapper;
        checkFileExists(this.filePath);
    }

    public Collection<Animal> getAnimals() {
        try {
            return Files.lines(filePath)
                .map(this::deserialize)
                .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            handleException(e);
            return Collections.emptyList();
        }
    }

    public Collection<Animal> addAnimal(Animal animal) {
        try {
            Files.write(filePath,
                Collections.singleton(serialize(animal)), CREATE, APPEND, WRITE);
        } catch (IOException e) {
            handleException(e);
            return Collections.emptyList();
        }

        return getAnimals();
    }

    public Collection<Animal> removeAnimal(String name) {
        Collection<Animal> existing = getAnimals();
        if (existing.removeIf(animal -> name.equals(animal.getName()))) {
            Collection<String> toUpdate = existing.stream()
                .map(this::serialize)
                .collect(Collectors.toCollection(ArrayList::new));

            try {
                Files.write(filePath, toUpdate, WRITE, TRUNCATE_EXISTING);
            } catch (IOException e) {
                handleException(e);
            }
        }

        return existing;
    }

    private void checkFileExists(Path filePath) {
        if (!Files.isReadable(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                handleException(e);
            }
        }
    }

    private String serialize(Animal animal) {
        try {
            return objectMapper.writeValueAsString(animal);
        } catch (JsonProcessingException e) {
            handleException(e);
            return null;
        }
    }

    private Animal deserialize(String source) {
        try {
            return objectMapper.readValue(source, Animal.class);
        } catch (IOException e) {
            handleException(e);
            return null;
        }
    }

    private void handleException(Exception e) {
        e.printStackTrace();
    }
}

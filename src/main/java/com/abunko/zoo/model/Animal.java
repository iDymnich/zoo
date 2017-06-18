package com.abunko.zoo.model;

import java.util.Objects;

public final class Animal {
    private final String name;
    private final String kind;
    private final String color;

    public Animal(String name, String kind, String color) {
        this.name = name;
        this.kind = kind;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Animal)) {
            return false;
        }
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) &&
            Objects.equals(kind, animal.kind) &&
            Objects.equals(color, animal.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, kind, color);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Animal{");
        sb.append("name='").append(name).append('\'');
        sb.append(", kind='").append(kind).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

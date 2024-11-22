package com.edsoft.lms.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer capacity;

    private Integer currentCapacity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "library_id")
    private List<Shelf> shelves = new ArrayList<>();
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return  Objects.equals(name, library.name);
    }

    public int hashCode() {
        return Objects.hash(name);
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(Integer currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }
}

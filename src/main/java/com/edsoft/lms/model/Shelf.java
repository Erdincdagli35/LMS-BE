package com.edsoft.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer storage;

    @JsonIgnore
    @ManyToOne(targetEntity = Library.class, cascade = {CascadeType.ALL})
    private Library library;
    /*
        @OneToMany(mappedBy = "shelf", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Book> books = new ArrayList<>();
    */
    @OneToMany(mappedBy = "shelf", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        book.setShelf(this);
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

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

package com.edsoft.lms.service.implementation;

import com.edsoft.lms.model.Book;
import com.edsoft.lms.model.Library;
import com.edsoft.lms.model.Shelf;
import com.edsoft.lms.repository.BookRepository;
import com.edsoft.lms.repository.LibraryRepository;
import com.edsoft.lms.repository.ShelfRepository;
import com.edsoft.lms.service.ShelfService;
import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShelfServiceImp implements ShelfService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    ShelfRepository shelfRepository;

    @Autowired
    LibraryRepository libraryRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shelf> getAll() {
        List<Shelf> shelves = shelfRepository.findAll();
        List<Shelf> relatedShelves = new ArrayList<>();

        for (Shelf shelf : shelves) {
            if (shelf.getLibrary() != null) {
                relatedShelves.add(shelf);
            }
        }

        return relatedShelves;
    }

    @Override
    public Shelf edit(Shelf shelfTemp, Shelf shelf) {
        shelfTemp.setName(shelf.getName());
        shelfTemp.setStorage(shelf.getStorage());

        return shelfRepository.save(shelfTemp);
    }

    @Override
    public Long delete(Shelf shelf) {
        Library library = shelf.getLibrary();
        library.setCurrentCapacity(library.getCapacity() - shelf.getStorage());
        libraryRepository.save(library);
        shelf.setLibrary(null);
        shelfRepository.delete(shelf);
        return shelf.getId();
    }

    @Override
    public Shelf getById(Long id) {
        return shelfRepository.findOneById(id);
    }

    @Override
    public List<Shelf> getByIds(Long[] ids) {
        List<Shelf> shelves = new ArrayList<>();
        for (Long id : ids) shelves.add(getById(id));
        return shelves;
    }

    @Override
    @Transactional
    public Long addToBook(Book book, Long shelfId) {
        // Fetch the shelf entity and ensure it is managed
        Shelf shelf = entityManager.find(Shelf.class, shelfId);

        if (shelf == null) {
            throw new EntityNotFoundException("Shelf not found");
        }

        // Add the book to the shelf
        shelf.addBook(book);

        // Merge the shelf to ensure it's managed and the book is cascaded
        entityManager.merge(shelf);

        if (shelf.getStorage() != 0) {
            shelf.setStorage(shelf.getStorage() - 1);
        }

        // No need to explicitly save the book, as it will be cascaded by the shelf
        return book.getId();
    }

}

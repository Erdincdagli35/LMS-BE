package com.edsoft.lms.service.implementation;

import com.edsoft.lms.model.Book;
import com.edsoft.lms.repository.BookRepository;
import com.edsoft.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAll(String name) {
        List<Book> books = bookRepository.findAll();
        return  books;
    }

    @Override
    public Book edit(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Long delete(Book book) {
        bookRepository.delete(book);
        return book.getId();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findOneById(id);
    }
}

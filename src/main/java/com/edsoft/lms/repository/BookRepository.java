package com.edsoft.lms.repository;

import com.edsoft.lms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findOneById(Long id);
    List<Book> findAll();
}

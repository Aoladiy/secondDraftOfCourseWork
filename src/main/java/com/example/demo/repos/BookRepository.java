package com.example.demo.repos;

import java.util.List;

import com.example.demo.models.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll(Sort sort);
    @Query("SELECT p FROM Book p WHERE CONCAT(p.nameBook, ' ', p.genre, ' ',  p.author, ' ', p.publishingHouse) LIKE %?1%")
    List<Book> search(String keyword);
}

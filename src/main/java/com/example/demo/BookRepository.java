package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll(Sort sort);
    @Query("SELECT p FROM Book p WHERE CONCAT(p.nameBook, ' ', p.publishingHouse, ' ',  p.dateIssue, ' ', p.nameStudent, ' ', p.dateDelivery) LIKE %?1%")
    List<Book> search(String keyword);
}

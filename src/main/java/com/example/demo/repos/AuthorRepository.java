package com.example.demo.repos;

import java.util.List;

import com.example.demo.models.Author;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAll(Sort sort);
    @Query("SELECT p FROM Author p WHERE CONCAT(p.fullName, ' ', p.birthDate, ' ', p.deathDate, ' ', p.biography) LIKE %?1%")
    List<Author> search(String keyword);
}

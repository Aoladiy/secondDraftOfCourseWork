package com.example.demo.repos;

import java.util.List;

import com.example.demo.models.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExampleRepository extends JpaRepository<Example, Long> {

    List<Example> findAll(Sort sort);
    @Query("SELECT p FROM Example p WHERE CONCAT(p.distinctiveFeatures, ' ', p.dateIssue, ' ',  p.dateReturn) LIKE %?1%")
    List<Example> search(String keyword);
    @Query("SELECT p FROM Example p WHERE CONCAT(p.readerId, '') LIKE %?1%")
    List<Example> searchByReaderId(String keyword);
    @Query("SELECT p FROM Example p WHERE CONCAT(p.bookId, '') LIKE %?1%")
    List<Example> searchByBookId(String keyword);
}

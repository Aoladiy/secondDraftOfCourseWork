package com.example.demo.repos;

import com.example.demo.models.Reader;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader, Long> {

    List<Reader> findAll(Sort sort);
    @Query("SELECT p FROM Reader p WHERE CONCAT(p.fullName, ' ', p.birthDate, ' ',  p.address, ' ', p.phoneNumber, ' ', p.registrationDate) LIKE %?1%")
    List<Reader> search(String keyword);
}

package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    public List<Book> listAll(String keyword, Boolean sortByYear, Boolean sortByNamebook,
                              Boolean sortByNamestudent, Boolean sortBydateissue,
                              Boolean sortBypublishingHouse, Boolean sortByid) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        if (sortByYear) {
            return repo.findAll(Sort.by("dateDelivery"));
        }
        if (sortByNamebook) {
            return repo.findAll(Sort.by("nameBook"));
        }
        if (sortByNamestudent) {
            return repo.findAll(Sort.by("nameStudent"));
        }
        if (sortBydateissue) {
            return repo.findAll(Sort.by("dateIssue"));
        }
        if (sortBypublishingHouse) {
            return repo.findAll(Sort.by("publishingHouse"));
        }
        if (sortByid) {
            return repo.findAll(Sort.by("id"));
        }
        else {
            return repo.findAll();
        }

    }

    public void save(Book book) {
        repo.save(book);
    }

    public Book get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}


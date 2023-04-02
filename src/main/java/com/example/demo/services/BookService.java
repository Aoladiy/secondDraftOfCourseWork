package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Book;
import com.example.demo.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    public List<Book> listAll(String keyword, Boolean sortByNamebook,
                              Boolean sortBypublishingHouse, Boolean sortByid) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        if (sortByNamebook) {
            return repo.findAll(Sort.by("nameBook"));
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


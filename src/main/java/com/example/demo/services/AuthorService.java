package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Author;
import com.example.demo.repos.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
@Service
public class AuthorService {
    @Autowired
    private AuthorRepository repo;

    public List<Author> listAll(String keyword, Boolean sortByFullName,
                                Boolean sortByBirthDate, Boolean sortByDeathDate, Boolean sortByBiography, Boolean sortById) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        if (sortByFullName) {
            return repo.findAll(Sort.by("fullName"));
        }
        if (sortByBirthDate) {
            return repo.findAll(Sort.by("birthDate"));
        }
        if (sortByDeathDate) {
            return repo.findAll(Sort.by("deathDate"));
        }
        if (sortByBiography) {
            return repo.findAll(Sort.by("biography"));
        }
        if (sortById) {
            return repo.findAll(Sort.by("id"));
        }
        else {
            return repo.findAll();
        }

    }

    public void save(Author book) {
        repo.save(book);
    }

    public Author get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}


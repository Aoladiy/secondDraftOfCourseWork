package com.example.demo.services;

import com.example.demo.models.Reader;
import com.example.demo.repos.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository repo;

    public List<Reader> listAll(String keyword, Boolean sortById, Boolean sortByFullName,
                                Boolean sortByBirthDate, Boolean sortByAddress, Boolean sortByPhoneNumber, Boolean sortByRegistrationDate) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        if (sortById) {
            return repo.findAll(Sort.by("id"));
        }
        if (sortByFullName) {
            return repo.findAll(Sort.by("fullName"));
        }
        if (sortByBirthDate) {
            return repo.findAll(Sort.by("birthDate"));
        }
        if (sortByAddress) {
            return repo.findAll(Sort.by("address"));
        }
        if (sortByPhoneNumber) {
            return repo.findAll(Sort.by("phoneNumber"));
        }
        if (sortByRegistrationDate) {
            return repo.findAll(Sort.by("registrationDate"));
        }
        else {
            return repo.findAll();
        }

    }

    public void save(Reader Reader) {
        repo.save(Reader);
    }

    public Reader get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}


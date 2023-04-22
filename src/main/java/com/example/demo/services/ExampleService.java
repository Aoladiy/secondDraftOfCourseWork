package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Example;
import com.example.demo.repos.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
@Service
public class ExampleService {
    @Autowired
    private ExampleRepository repo;

    public List<Example> listAll(String keyword, Boolean sortById, Boolean sortByDistinctiveFeatures,
                                 Boolean sortByDateIssue, Boolean sortByDateReturn) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        if (sortById) {
            return repo.findAll(Sort.by("id"));
        }
        if (sortByDistinctiveFeatures) {
            return repo.findAll(Sort.by("distinctiveFeatures"));
        }
        if (sortByDateIssue) {
            return repo.findAll(Sort.by("dateIssue"));
        }
        if (sortByDateReturn) {
            return repo.findAll(Sort.by("dateReturn"));
        }
        else {
            return repo.findAll();
        }

    }

    public void save(Example Example) {
        repo.save(Example);
    }

    public Example get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}


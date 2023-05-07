package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Example;
import com.example.demo.repos.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

/**
 * Сервис для работы с сущностью Пример.
 */
@Service
public class ExampleService {

    @Autowired
    private ExampleRepository repo;

    /**
     * Получить список всех примеров в зависимости от параметров.
     *
     * @param keyword                   ключевое слово для поиска в особенностях, датах выдачи и возврата
     * @param ByReaderId                идентификатор читателя для поиска
     * @param ByBookId                  идентификатор книги для поиска
     * @param sortById                  флаг сортировки по идентификатору
     * @param sortByDistinctiveFeatures флаг сортировки по особенностям
     * @param sortByDateIssue           флаг сортировки по дате выдачи
     * @param sortByDateReturn          флаг сортировки по дате возврата
     * @return список примеров
     */
    public List<Example> listAll(String keyword, String ByReaderId, String ByBookId, Boolean sortById, Boolean sortByDistinctiveFeatures,
                                 Boolean sortByDateIssue, Boolean sortByDateReturn) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        if (ByReaderId != null) {
            return repo.searchByReaderId(ByReaderId);
        }
        if (ByBookId != null) {
            return repo.searchByBookId(ByBookId);
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
        } else {
            return repo.findAll();
        }
    }

    /**
     * Сохранить пример.
     *
     * @param example пример
     */
    public void save(Example example) {
        repo.save(example);
    }

    /**
     * Получить пример по идентификатору.
     *
     * @param id идентификатор примера
     * @return пример
     */
    public Example get(Long id) {
        return repo.findById(id).get();
    }

    /**
     * Удалить пример по идентификатору.
     *
     * @param id идентификатор примера
     */
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
package com.example.demo.services;

import com.example.demo.models.Reader;
import com.example.demo.repos.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с сущностью Читатель.
 */
@Service
public class ReaderService {

    @Autowired
    private ReaderRepository repo;

    /**
     * Получить список всех читателей в зависимости от параметров.
     *
     * @param keyword                ключевое слово для поиска в полном имени, дате рождения, адресе, номере телефона и дате регистрации
     * @param sortById               флаг сортировки по идентификатору
     * @param sortByFullName         флаг сортировки по полному имени
     * @param sortByBirthDate        флаг сортировки по дате рождения
     * @param sortByAddress          флаг сортировки по адресу
     * @param sortByPhoneNumber      флаг сортировки по номеру телефона
     * @param sortByRegistrationDate флаг сортировки по дате регистрации
     * @return список читателей
     */
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
        } else {
            return repo.findAll();
        }
    }

    /**
     * Сохранить читателя.
     *
     * @param reader читатель
     */
    public void save(Reader reader) {
        repo.save(reader);
    }

    /**
     * Получить читателя по идентификатору.
     *
     * @param id идентификатор читателя
     * @return читатель
     */
    public Reader get(Long id) {
        return repo.findById(id).get();
    }

    /**
     * Удалить читателя по идентификатору.
     *
     * @param id идентификатор читателя
     */
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
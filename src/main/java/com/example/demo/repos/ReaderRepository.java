package com.example.demo.repos;

import com.example.demo.models.Reader;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Репозиторий для работы с сущностью Читатель.
 */
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    /**
     * Получить список всех читателей с сортировкой.
     *
     * @param sort сортировка
     * @return список читателей
     */
    List<Reader> findAll(Sort sort);

    /**
     * Поиск читателей по ключевому слову в полном имени, дате рождения, адресе, номеру телефона и дате регистрации.
     *
     * @param keyword ключевое слово
     * @return список читателей, которые содержат ключевое слово в полном имени, дате рождения, адресе, номере телефона или дате регистрации
     */
    @Query("SELECT p FROM Reader p WHERE CONCAT(p.fullName, ' ', p.birthDate, ' ',  p.address, ' ', p.phoneNumber, ' ', p.registrationDate) LIKE %?1%")
    List<Reader> search(String keyword);
}

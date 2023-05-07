package com.example.demo.repos;

import java.util.List;

import com.example.demo.models.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Репозиторий для работы с сущностью Экземпляр.
 */
public interface ExampleRepository extends JpaRepository<Example, Long> {

    /**
     * Получить список всех экземпляров с сортировкой.
     *
     * @param sort сортировка
     * @return список экземпляров
     */
    List<Example> findAll(Sort sort);

    /**
     * Поиск экземпляров по ключевому слову в особенностях, датах выдачи и возврата.
     *
     * @param keyword ключевое слово
     * @return список экземпляров, которые содержат ключевое слово в особенностях, датах выдачи или возврата
     */
    @Query("SELECT p FROM Example p WHERE CONCAT(p.distinctiveFeatures, ' ', p.dateIssue, ' ',  p.dateReturn) LIKE %?1%")
    List<Example> search(String keyword);

    /**
     * Поиск экземпляров по идентификатору читателя.
     *
     * @param keyword идентификатор читателя
     * @return список экземпляров, связанных с указанным читателем
     */
    @Query("SELECT p FROM Example p WHERE CONCAT(p.readerId, '') LIKE %?1%")
    List<Example> searchByReaderId(String keyword);

    /**
     * Поиск экземпляров по идентификатору книги.
     *
     * @param keyword идентификатор книги
     * @return список экземпляров, связанных с указанной книгой
     */
    @Query("SELECT p FROM Example p WHERE CONCAT(p.bookId, '') LIKE %?1%")
    List<Example> searchByBookId(String keyword);
}

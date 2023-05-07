package com.example.demo.repos;

import java.util.List;

import com.example.demo.models.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Репозиторий для работы с сущностью Книга.
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Получить список всех книг с сортировкой.
     *
     * @param sort сортировка
     * @return список книг
     */
    List<Book> findAll(Sort sort);

    /**
     * Поиск книг по ключевому слову в названии, жанре, авторе и издательстве.
     *
     * @param keyword ключевое слово
     * @return список книг, которые содержат ключевое слово в названии, жанре, авторе или издательстве
     */
    @Query("SELECT p FROM Book p WHERE CONCAT(p.nameBook, ' ', p.genre, ' ',  p.author, ' ', p.publishingHouse) LIKE %?1%")
    List<Book> search(String keyword);
}
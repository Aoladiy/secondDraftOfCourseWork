package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Book;
import com.example.demo.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

/**
 * Сервис для работы с сущностью Книга.
 */
@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    /**
     * Получить список всех книг в зависимости от параметров.
     *
     * @param keyword               ключевое слово для поиска
     * @param sortById              флаг сортировки по идентификатору
     * @param sortByNameBook        флаг сортировки по названию книги
     * @param sortByGenre           флаг сортировки по жанру
     * @param sortByAuthor          флаг сортировки по автору
     * @param sortByPublishingHouse флаг сортировки по издательству
     * @return список книг
     */
    public List<Book> listAll(String keyword, Boolean sortById, Boolean sortByNameBook,
                              Boolean sortByGenre, Boolean sortByAuthor, Boolean sortByPublishingHouse) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        if (sortById) {
            return repo.findAll(Sort.by("id"));
        }
        if (sortByNameBook) {
            return repo.findAll(Sort.by("nameBook"));
        }
        if (sortByGenre) {
            return repo.findAll(Sort.by("genre"));
        }
        if (sortByAuthor) {
            return repo.findAll(Sort.by("author"));
        }
        if (sortByPublishingHouse) {
            return repo.findAll(Sort.by("publishingHouse"));
        } else {
            return repo.findAll();
        }
    }

    /**
     * Сохранить книгу.
     *
     * @param book книга
     */
    public void save(Book book) {
        repo.save(book);
    }

    /**
     * Получить книгу по идентификатору.
     *
     * @param id идентификатор книги
     * @return книга
     */
    public Book get(Long id) {
        return repo.findById(id).get();
    }

    /**
     * Удалить книгу по идентификатору.
     *
     * @param id идентификатор книги
     */
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
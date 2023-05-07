package com.example.demo.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.models.Book;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для управления книгами.
 */
@Controller
public class BookController {

    @Autowired
    private BookService service;

    /**
     * Отображает страницу со списком книг.
     *
     * @param model                 Модель
     * @param keyword               Ключевое слово для поиска книг
     * @param sortById              Сортировать по ID
     * @param sortByNameBook        Сортировать по названию книги
     * @param sortByGenre           Сортировать по жанру книги
     * @param sortByAuthor          Сортировать по автору книги
     * @param sortByPublishingHouse Сортировать по издательству книги
     * @return Представление со списком книг
     */
    @RequestMapping("/books/")
    public String viewHomePage(Model model, @Param("keyword") String keyword,
                               @RequestParam(value = "sortById", required = false, defaultValue = "false") boolean sortById,
                               @RequestParam(value = "sortByNameBook", required = false, defaultValue = "false") boolean sortByNameBook,
                               @RequestParam(value = "sortByGenre", required = false, defaultValue = "false") boolean sortByGenre,
                               @RequestParam(value = "sortByAuthor", required = false, defaultValue = "false") boolean sortByAuthor,
                               @RequestParam(value = "sortByPublishingHouse", required = false, defaultValue = "false") boolean sortByPublishingHouse
    ) {
        List<Book> listBooks = service.listAll(keyword, sortById, sortByNameBook, sortByGenre, sortByAuthor, sortByPublishingHouse);
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("keyword", keyword);
        return "book/books";
    }

    /**
     * Отображает страницу с информацией о конкретной книге.
     *
     * @param model Модель
     * @param id    Идентификатор книги
     * @return Представление с информацией о книге
     * @throws NoSuchElementException если книга с указанным идентификатором не найдена
     */
    @RequestMapping("/book/{id}")
    public String someFunction(Model model, @PathVariable(name = "id") Long id) throws NoSuchElementException {
        try {
            Book book = service.get(id);
            model.addAttribute(book);
            return "book/book";
        } catch (NoSuchElementException e) {
            return "exceptions/notFoundBook";
        }
    }

    /**
     * Отображает страницу создания новой книги.
     *
     * @param model Модель
     * @return Представление для создания новой книги
     */
    @RequestMapping("/books/new")
    public String showNewBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book/new_book";
    }

    /**
     * Сохраняет новую книгу.
     *
     * @param book Книга для сохранения
     * @return Перенаправление на страницу со списком книг
     */
    @RequestMapping(value = "/books/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book) {
        service.save(book);
        return "redirect:/books/";
    }

    /**
     * Отображает страницу редактирования книги.
     *
     * @param id Идентификатор книги для редактирования
     * @return Модель и представление для редактирования книги
     */
    @RequestMapping("/books/edit/{id}")
    public ModelAndView showEditBookForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("book/edit_book");
        Book book = service.get(id);
        mav.addObject("book", book);
        return mav;
    }

    /**
     * Удаляет книгу.
     *
     * @param id Идентификатор книги для удаления
     * @return Перенаправление на страницу со списком книг
     */
    @RequestMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/books/";
    }
}
package com.example.demo.controllers;

import java.util.List;

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

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @RequestMapping("/books")
    public String viewHomePage(Model model, @Param("keyword") String keyword,
                               @RequestParam(value = "sortByNameBook", required = false, defaultValue = "false") boolean sortByNameBook,
                               @RequestParam(value = "sortByBirthDate", required = false, defaultValue = "false") boolean sortByPublishingHouse,
                               @RequestParam(value = "sort_by_id", required = false, defaultValue = "false") boolean sortById

    )
    {
        List<Book> listBooks = service.listAll(keyword, sortByNameBook, sortByPublishingHouse, sortById);
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("keyword", keyword);
        return "books";
    }

    @RequestMapping("/books/new")
    public String showNewBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book_new";
    }

    @RequestMapping(value = "/books/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book) {
        service.save(book);
        return "redirect:/";
    }

    @RequestMapping("/books/edit/{id}")
    public ModelAndView showEditBookForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("book_edit");
        Book book = service.get(id);
        mav.addObject("book", book);
        return mav;
    }

    @RequestMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/books";
    }
}
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
public class AppController {

    @Autowired
    private BookService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword,
                               @RequestParam(value = "sort_by_year", required = false, defaultValue = "false") boolean sortByYear,
                               @RequestParam(value = "sort_by_name_book", required = false, defaultValue = "false") boolean sortByNamebook,
                               @RequestParam(value = "sort_by_name_student", required = false, defaultValue = "false") boolean sortByNamestudent,
                               @RequestParam(value = "sort_by_date_issue", required = false, defaultValue = "false") boolean sortBydateissue,
                               @RequestParam(value = "sort_by_publishing_house", required = false, defaultValue = "false") boolean sortBypublishinghouse,
                               @RequestParam(value = "sort_by_id", required = false, defaultValue = "false") boolean sortByid

    )
    {
        List<Book> listBooks = service.listAll(keyword, sortByYear, sortByNamebook, sortByNamestudent, sortBydateissue, sortBypublishinghouse, sortByid);
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewStudentForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "new_book";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("book") Book book) {
        service.save(book);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_book");
        Book book = service.get(id);
        mav.addObject("book", book);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}

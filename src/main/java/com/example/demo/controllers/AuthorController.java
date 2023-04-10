package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.Author;
import com.example.demo.services.AuthorService;
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
public class AuthorController {

    @Autowired
    private AuthorService service;

    @RequestMapping("/authors")
    public String viewAuthorsPage(Model model, @Param("keyword") String keyword,
                                  @RequestParam(value = "sortByFullName", required = false, defaultValue = "false") boolean sortByFullName,
                                  @RequestParam(value = "sortByBirthDate", required = false, defaultValue = "false") boolean sortByBirthDate,
                                  @RequestParam(value = "sortByDeathDate", required = false, defaultValue = "false") boolean sortByDeathDate,
                                  @RequestParam(value = "sortByBiography", required = false, defaultValue = "false") boolean sortByBiography,
                                  @RequestParam(value = "sort_by_id", required = false, defaultValue = "false") boolean sortById

    )
    {
        List<Author> listAuthors = service.listAll(keyword, sortByFullName, sortByBirthDate, sortByDeathDate, sortByBiography, sortById);
        model.addAttribute("listAuthors", listAuthors);
        model.addAttribute("keyword", keyword);
        return "authors";
    }

    @RequestMapping("/authors/new")
    public String showNewAuthorsForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "author_new";
    }

    @RequestMapping(value = "/authors/save", method = RequestMethod.POST)
    public String saveAuthors(@ModelAttribute("author") Author author) {
        service.save(author);
        return "redirect:/";
    }

    @RequestMapping("/authors/edit/{id}")
    public ModelAndView showEditAuthorsForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("author_edit");
        Author author = service.get(id);
        mav.addObject("author", author);
        return mav;
    }

    @RequestMapping("/authors/delete/{id}")
    public String deleteAuthors(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/authors";
    }
}

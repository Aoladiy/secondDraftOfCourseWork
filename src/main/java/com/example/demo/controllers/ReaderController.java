package com.example.demo.controllers;

import com.example.demo.models.Reader;
import com.example.demo.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReaderController {

    @Autowired
    private ReaderService service;

    @RequestMapping("/readers/")
    public String viewHomePage(Model model, @Param("keyword") String keyword,
                               @RequestParam(value = "sortById", required = false, defaultValue = "false") boolean sortById,
                               @RequestParam(value = "sortByFullName", required = false, defaultValue = "false") boolean sortByFullName,
                               @RequestParam(value = "sortByBirthDate", required = false, defaultValue = "false") boolean sortByBirthDate,
                               @RequestParam(value = "sortByAddress", required = false, defaultValue = "false") boolean sortByAddress,
                               @RequestParam(value = "sortByPhoneNumber", required = false, defaultValue = "false") boolean sortByPhoneNumber,
                               @RequestParam(value = "sortByRegistrationDate", required = false, defaultValue = "false") boolean sortByRegistrationDate
    )
    {
        List<Reader> listReaders = service.listAll(keyword, sortById, sortByFullName, sortByBirthDate, sortByAddress, sortByPhoneNumber, sortByRegistrationDate);
        model.addAttribute("listReaders", listReaders);
        model.addAttribute("keyword", keyword);
        return "reader/readers";
    }

    @RequestMapping("/reader/{id}")
    public String someFunction(Model model, @PathVariable(name = "id") Long id) {
        Reader reader = service.get(id);
        model.addAttribute(reader);
        return "reader/reader";
    }

    @RequestMapping("/readers/new")
    public String showNewReaderForm(Model model) {
        Reader reader = new Reader();
        model.addAttribute("reader", reader);
        return "reader/new_reader";
    }

    @RequestMapping(value = "/readers/save", method = RequestMethod.POST)
    public String saveReader(@ModelAttribute("reader") Reader reader) {
        service.save(reader);
        return "redirect:/readers/";
    }

    @RequestMapping("/readers/edit/{id}")
    public ModelAndView showEditReaderForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("reader/edit_reader");
        Reader reader = service.get(id);
        mav.addObject("reader", reader);
        return mav;
    }

    @RequestMapping("/readers/delete/{id}")
    public String deleteReader(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/readers/";
    }
}

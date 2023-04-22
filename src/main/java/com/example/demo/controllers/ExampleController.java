package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.Example;
import com.example.demo.services.ExampleService;
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
public class ExampleController {

    @Autowired
    private ExampleService service;

    @RequestMapping("/examples/")
    public String viewHomePage(Model model, @Param("keyword") String keyword,
                               @RequestParam(value = "sortById", required = false, defaultValue = "false") boolean sortById,
                               @RequestParam(value = "sortByDistinctiveFeatures", required = false, defaultValue = "false") boolean sortByDistinctiveFeatures,
                               @RequestParam(value = "sortByDateIssue", required = false, defaultValue = "false") boolean sortByDateIssue,
                               @RequestParam(value = "sortByDateReturn", required = false, defaultValue = "false") boolean sortByDateReturn
    )
    {
        List<Example> listExamples = service.listAll(keyword, sortById, sortByDistinctiveFeatures, sortByDateIssue, sortByDateReturn);
        model.addAttribute("listExamples", listExamples);
        model.addAttribute("keyword", keyword);
        return "example/examples";
    }

    @RequestMapping("/example/{id}")
    public String someFunction(Model model, @PathVariable(name = "id") Long id) {
        Example Example = service.get(id);
        model.addAttribute(Example);
        return "example/example";
    }

    @RequestMapping("/examples/new")
    public String showNewExampleForm(Model model) {
        Example example = new Example();
        model.addAttribute("example", example);
        return "example/new_example";
    }

    @RequestMapping(value = "/examples/save", method = RequestMethod.POST)
    public String saveExample(@ModelAttribute("example") Example example) {
        service.save(example);
        return "redirect:/examples/";
    }

    @RequestMapping("/examples/edit/{id}")
    public ModelAndView showEditExampleForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("example/edit_example");
        Example example = service.get(id);
        mav.addObject("example", example);
        return mav;
    }

    @RequestMapping("/examples/delete/{id}")
    public String deleteExample(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/examples/";
    }
}

package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AppController {
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }
    @RequestMapping("/about/")
    public String viewAboutPage(Model model) {
        return "about_author";
    }
}

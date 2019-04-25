package com.example.demo.controller;

import com.example.demo.repo.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    private BookRepository bookRepository;

    public FirstController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("books",bookRepository.findAll());
        return "index";
    }
}

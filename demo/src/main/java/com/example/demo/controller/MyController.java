package com.example.demo.controller;

import com.example.demo.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class MyController {


    private UserRepo userRepo;

    @Autowired
    public MyController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @RequestMapping("/")
    public String getIndex(Model model){
        model.addAttribute("users",userRepo.findAll());
        return "index";
    }


}

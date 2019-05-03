package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.demo.model.User.createUser;

@Controller
@RequestMapping("/")
public class MyController {


    private UserRepo userRepo;

    @Autowired
    public MyController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("users",userRepo.findAll());
        model.addAttribute("newuser", createUser());
        return "index";
    }

    @PostMapping
    public String getNewUser(User user){
        userRepo.save(user);
        return "redirect:/";

    }


}

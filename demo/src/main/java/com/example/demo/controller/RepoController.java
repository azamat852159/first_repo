package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class RepoController {

    private UserRepo userRepo;

    public RepoController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String getSign(Model model){
        model.addAttribute("users",userRepo.findAll());
        model.addAttribute("newuser", User.createUser());
        return "index";
    }

    //метод для авторизации
  @PostMapping
  public String getRepo(User user){
      userRepo.save(user);
        return "redirect:/";
  }


}

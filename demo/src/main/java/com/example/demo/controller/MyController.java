package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.demo.model.User.createUser;

@Controller
@RequestMapping(value = "/")
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
        if (Check.createCheck().methodCheck(user) == 0) {
            userRepo.save(user);
        }
            return "redirect:/";
    }
}

class Check{
    private Check() {
    }

    @NotNull
    @Contract(" -> new")
    public static Check createCheck(){
        return new Check();
    }

    public int methodCheck(User user){
        if (user.getPassword().equals("") || "".equals(user.getPassword())) {
            return 1;
        } else
            return 0;
    }
}

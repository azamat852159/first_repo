package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String mail;
    private String password;

    public User(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public User() {
    }


    @NotNull
    @Contract(" -> new")
    public static User createUser(){
        return new User();
    }
}

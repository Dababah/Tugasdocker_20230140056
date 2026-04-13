package com.example.dockerfiledevelop.controller;


import com.example.dockerfiledevelop.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // List static untuk menampung data sementara (temporary)
    private static List<User> userList = new ArrayList<>();

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Ganti password sesuai NIM Anda
        if ("FAWWAZGANTENG".equals(username) && "20230140056".equals(password)) {
            return "redirect:/home";
        }
        model.addAttribute("error", "Username atau Password Salah!");
        return "login";
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("users", userList);
        return "home";
    }

    @GetMapping("/form")
    public String showFormPage() {
        return "form";
    }

    @PostMapping("/submit-form")
    public String submitForm(@RequestParam String nama, @RequestParam String nim, @RequestParam String jenisKelamin) {
        userList.add(new User(nama, nim, jenisKelamin));
        return "redirect:/home";
    }
}
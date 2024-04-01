package com.ceica.firstspringcomplete.controller;

import com.ceica.firstspringcomplete.model.User;
import com.ceica.firstspringcomplete.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute User user) {
        user.setEnabled(true);
        userService.newUser(user);
        return "login";
    }

    @GetMapping("/error")
    public String error(){
        return "home";
    }
}
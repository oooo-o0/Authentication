package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/info")
    public String showInfo() {
        return "userInfo";
    }
    @GetMapping("/news")
    public String showNews() {
        return "userNews";
    }
}

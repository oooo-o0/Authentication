package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpSession;


@RequiredArgsConstructor
@Controller
public class AuthController {

    private final HttpSession session;
    private final LoginService service;
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String loginId, @RequestParam String pass, Model model) {
        if(!service.checkIdAndPass(loginId, pass)) {
            model.addAttribute("errorMsg", "ログイン情報が不正です");
            return "login";
        }
        session.setAttribute("loginId", loginId);
        return "redirect:/user/info";
    }
    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/login";
    }
    
    
}

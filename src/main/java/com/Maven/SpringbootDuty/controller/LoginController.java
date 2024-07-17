package com.Maven.SpringbootDuty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Maven.SpringbootDuty.service.LoginService;

@RestController
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "LoginForm";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = loginService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (isAuthenticated) {
            // Ideally, you should set a session attribute here
            return "Login Successful, hello " + loginRequest.getUsername();
        } else {
            return "Invalid username or password";
        }
    }
    
}
package com.Maven.SpringbootDuty.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public ModelAndView showLoginForm() {
    	return new ModelAndView("redirect:/LoginForm.html");
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        boolean isAuthenticated = loginService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (isAuthenticated) {
            request.getSession().setAttribute("username", loginRequest.getUsername());
            return "Login Successful, hello " + loginRequest.getUsername();
        } else {
            return "Invalid username or password";
        }
    }

    
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return new ModelAndView("redirect:/LoginForm.html");
    }
    
}
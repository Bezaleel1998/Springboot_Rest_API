package com.Maven.SpringbootDuty.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Maven.SpringbootDuty.controller.LoginController;
import com.Maven.SpringbootDuty.entity.Login;
import com.Maven.SpringbootDuty.repository.LoginRepository;

@Service
public class LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginRepository loginRepository;

    public boolean authenticate(String username, String password) {
        Login user = loginRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
        	logger.info("username: {}, password: {}", user.getUsername(), user.getPassword());
            return true;
        }
        return false;
    }
}
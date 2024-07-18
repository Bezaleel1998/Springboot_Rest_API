package com.Maven.SpringbootDuty.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Maven.SpringbootDuty.entity.Login;
import com.Maven.SpringbootDuty.repository.LoginRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginRepository.findByUsername(username);
        if (login == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.builder()
                .username(login.getUsername())
                .password(login.getPassword())
                .roles(login.getRole())
                .build();
    }
}

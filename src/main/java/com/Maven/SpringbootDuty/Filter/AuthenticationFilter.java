package com.Maven.SpringbootDuty.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/LoginForm.html";

        boolean loggedIn = session != null && session.getAttribute("username") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean isStaticResource = request.getRequestURI().startsWith(request.getContextPath() + "/static/");

        if (loggedIn || loginRequest || isStaticResource) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }
}
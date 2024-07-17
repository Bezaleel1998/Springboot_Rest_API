package com.Maven.SpringbootDuty.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> loggingFilter(){
        FilterRegistrationBean<AuthenticationFilter> registrationBean 
          = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AuthenticationFilter());
        
        registrationBean.addUrlPatterns("/productList.html"); // Add all the URL patterns to be filtered
        registrationBean.addUrlPatterns("/cart.html");
        
        return registrationBean;    
    }
}
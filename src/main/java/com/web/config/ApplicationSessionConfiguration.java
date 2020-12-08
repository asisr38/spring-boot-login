package com.web.config;

import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.web.listener.AppSessionListener;
import com.web.service.LoginService;

@Configuration
public class ApplicationSessionConfiguration{
	
	
	@Autowired
	private LoginService loginService;
	
	//This is the way , how spring container make a bean of a given listener!
    @Bean
    public ServletListenerRegistrationBean<HttpSessionListener> sessionListener() {
    	System.out.println(")#I(#&*#^&#&^#%#");
        return new ServletListenerRegistrationBean<HttpSessionListener>(new AppSessionListener(loginService));
    }
} 
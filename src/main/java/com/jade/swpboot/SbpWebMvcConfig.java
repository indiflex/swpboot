package com.jade.swpboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jade.swpboot.interceptor.HelloInterceptor;

@Configuration
public class SbpWebMvcConfig implements WebMvcConfigurer {
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HelloInterceptor())
        	.addPathPatterns("/hello");
    }
	
}

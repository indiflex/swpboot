package com.jade.swpboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HelloInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler)
			throws Exception {
		
		System.out.println("HelloInterceptor.pre>>");
		
		return true;
	}

	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, 
			Object handler, ModelAndView modelAndView) throws Exception {
		
		HandlerMethod method = (HandlerMethod) handler;
		System.out.println("MMMM>> Bean: " + method.getBean() + ", Method: " + method.getMethod());
	}
}

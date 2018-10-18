package com.jade.swpboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jade.swpboot.domain.User;
import com.jade.swpboot.mapper.UserMapper;

@Controller
public class UserController {
	
	@Autowired
	private UserMapper mapper;
	
	@RequestMapping("/hello2")
	public void hello2(Model model) throws Exception {
		System.out.println("HELLO222222222222222222222222222");
		model.addAttribute("uname", "전성호2");
		
		List<User> users = mapper.getUsers();
		System.out.println("UUUUUsers>>" + users.size());
		model.addAttribute("users", users);
		
		if (users != null && users.size() > 0)
		model.addAttribute("user", users.get(0));
	}
	
	@RequestMapping(value="/korean", method=RequestMethod.POST)
	public String korean(@RequestParam String name, Model model) {
		System.out.println("name=" + name);
		model.addAttribute("name", name);
		
		return "/hello2";
	}
}

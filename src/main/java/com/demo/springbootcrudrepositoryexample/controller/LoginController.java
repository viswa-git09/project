package com.demo.springbootcrudrepositoryexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootcrudrepositoryexample.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("{userId}")
	public String userLogin(@PathVariable Long userId) {
		 Boolean userById = userService.getUserById(userId);
		 if(userById) {
			 return "Welcome to login";
		 }
		
		return "your not register person to login please sigin frist";
		
	}

}

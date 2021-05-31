package com.demo.springbootcrudrepositoryexample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootcrudrepositoryexample.entity.User;
import com.demo.springbootcrudrepositoryexample.service.UserService;

@RestController
@RequestMapping("/ user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	  @PostMapping("/user") 
	  public User createuser(@RequestBody User user) {
	  
	  return userService.createUser(user); }
	 
	
	@GetMapping("/user")
	public Iterable<User> getAllUser() {
		
		return userService.getAllUser();
	}
	
	@PutMapping("/user")
	public User updateuser(@RequestBody User user) {
		
		return userService.createUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public Object deleteuser(@PathVariable Long id) {
		return userService.deleteUser(id);
		
	}
	

}

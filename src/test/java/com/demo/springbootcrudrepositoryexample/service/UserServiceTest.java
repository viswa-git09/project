
package com.demo.springbootcrudrepositoryexample.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.demo.springbootcrudrepositoryexample.controller.UserController;
import com.demo.springbootcrudrepositoryexample.entity.User;

class UserServiceTest {
	@Mock
	UserRepository userRepository;
	
	@Mock
	UserController userController;

	@InjectMocks
	UserService userService;
	
	static List<User> userList;

  @Test
  @DisplayName("Save UserDetails")
  public void createUserTest(){
  
	User user = null;
	// context
	  when(userService.createUser(user)).thenReturn(user);
	  User result = userController.createuser(user); 
	  
	// outcome
	assertEquals(user, result);
		}

		/*
		 * @Test
		 * 
		 * @DisplayName("Get User By Id") void getUserByIdTest() {
		 * 
		 * when(userRepository.findById(1L)).thenReturn(Optional.of(customUser));
		 * 
		 * // event Boolean result = userService.getUserById(1L);
		 * 
		 * verify(userRepository).findById(1L);
		 * 
		 * // outcome assertEquals(customUser, result); }
		 */
  
  
}
 
package com.demo.springbootcrudrepositoryexample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springbootcrudrepositoryexample.entity.User;
import com.demo.springbootcrudrepositoryexample.exception.EmptyInputException;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public User createUser(User user) {
		
		if(user.getName().isEmpty() || user.getName().length()==0) {
			
			throw new EmptyInputException ("601", "Input fields are Empty");
		}
		
			return userRepository.save(user);
	}

	public Iterable<User> getAllUser() {
		
		Iterable<User> findAll = userRepository.findAll();
		return findAll;
	}

	public Object deleteUser(Long id) {
		
		 userRepository.deleteById(id);
		return id;
	}

	public Boolean getUserById(Long userId) {
		Optional<User> findById = userRepository.findById(userId);
		if(findById.isPresent()) {
			return true;
		}
		return false;
	}

	

}

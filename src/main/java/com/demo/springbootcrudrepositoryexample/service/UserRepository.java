package com.demo.springbootcrudrepositoryexample.service;

import org.springframework.data.repository.CrudRepository;

import com.demo.springbootcrudrepositoryexample.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	

}

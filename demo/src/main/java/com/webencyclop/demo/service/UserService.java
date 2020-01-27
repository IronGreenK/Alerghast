package com.webencyclop.demo.service;

import java.util.List;
import java.util.Optional;

import com.webencyclop.demo.model.User;


public interface UserService {

	public void saveUser(User user);
	
	public boolean isUserAlreadyPresent(User user);
	
	public Optional<User> findById(int id);
	public Optional<User> findByEmail(String email);
    
	public List<User> findAll();
}

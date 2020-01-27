package com.webencyclop.demo.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webencyclop.demo.model.Role;
import com.webencyclop.demo.model.User;


import com.webencyclop.demo.repository.RoleRepository;
import com.webencyclop.demo.repository.UserRepository;



@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setStatus("VERIFIED");
		Role userRole = roleRepository.findByRole("SITE_USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

		userRepository.save(user);
	}
	public boolean login(User user) {
		if (findByEmail(user.getEmail()).isPresent()) {
			String userWithotEncryoted = user.getPassword();
			String encryptedPassword = passEncryp(user);
			boolean isPasswordMatches=encoder.matches(userWithotEncryoted, encryptedPassword);
			return false;
		}else {
			return true;
		}	//no terminado
	}
	@Override
	public boolean isUserAlreadyPresent(User user) {
		if (!findByEmail(user.getEmail()).isPresent()) {
			
			return false;
		}else {
			return true;
		}	
	}
	
	 @Override
	 public Optional<User> findById(int id) {
	        return this.userRepository.findById(id);
	 }
	 @Override
	   	public List<User> findAll() {
	        return this.userRepository.findAll();
	    }
	@Override
	public Optional<User> findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
	public String passEncryp(User user) {
		return user.getPassword();
		//no terminado
	}

}

package com.webencyclop.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.webencyclop.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findById(int id);
	public Optional<User> findByEmail(String email);
}


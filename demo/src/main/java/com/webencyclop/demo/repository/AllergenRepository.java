package com.webencyclop.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.webencyclop.demo.model.Allergens;

@Repository
public interface AllergenRepository extends JpaRepository<Allergens, Integer> {
}
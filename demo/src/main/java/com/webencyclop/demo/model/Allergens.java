package com.webencyclop.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "allergens")
public class Allergens {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "allergen_id")
	private int id;

	@Column(name = "allergen_name")
	private String allergen;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAllergen() {
		return allergen;
	}
	public void setAllergen(String allergen) {
		this.allergen = allergen;
	}
	
}
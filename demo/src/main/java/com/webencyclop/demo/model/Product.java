package com.webencyclop.demo.model;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class Product {
	public String ingredients;
	public String allergens;

    
    @JsonbTransient
    public boolean legendary = true;

    public Product() {
		
	}
    
    @JsonbCreator
    //or custom constructor can be used
    public Product(
      @JsonbProperty("ingredients_text_en") String ingredients,
      @JsonbProperty("allergens") String allergens) {

      this.ingredients = ingredients;
      this.allergens = allergens;
    }

    @Override
    public String toString() {
      return "Los ingredientes son: "+ ingredients + "y sus alérgenos son: " + allergens;
    }
}

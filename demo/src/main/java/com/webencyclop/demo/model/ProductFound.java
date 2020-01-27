package com.webencyclop.demo.model;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class ProductFound{
	public String status;
	public Product product[];
	public String code;

    
    @JsonbTransient
    public boolean legendary = true;

    public ProductFound() {
		
	}
    
    @JsonbCreator
    //or custom constructor can be used
    public ProductFound(
      @JsonbProperty("status_verbose") String status,
      @JsonbProperty("product") Product product[],
      @JsonbProperty("code") String code) {

      this.status = status;
      this.product = product;
      this.code = code;
    }

    @Override
    public String toString() {
      return "El codigo: "+ code + " su estado: " + product.length + " y su estado: "+status;
    }
    
    

    
}
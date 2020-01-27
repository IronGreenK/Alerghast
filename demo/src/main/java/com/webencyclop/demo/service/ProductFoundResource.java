package com.webencyclop.demo.service;

import javax.json.JsonArray;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.webencyclop.demo.model.ProductFound;
import com.webencyclop.demo.consuming.Consumer;


@Path("productFound")
public class ProductFoundResource {

    @Context
    UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray getProductFound() {
            return Reader.getProductFound();
    }

    @GET
    @Path("jsonString")
    @Produces(MediaType.TEXT_PLAIN)
    public String getJsonString() {
      Jsonb jsonb = JsonbBuilder.create();
      ProductFound[] productFounds = Consumer.consumeWithJsonb(uriInfo.getBaseUri().toString() +
        "productFound");
      String result = jsonb.toJson(productFounds);

      return result;
    }
    
    @GET
    @Path("total/{productFound}")
    @Produces(MediaType.TEXT_PLAIN)
    public int getTotalProduct(@PathParam("productFound") String productFound) {
    	ProductFound[] productFounds = Consumer.consumeWithJsonb(uriInfo.getBaseUri().toString()
        + "productFound");

      for (int i = 0; i < productFounds.length; i++) {
        if (productFounds[i].status.equals(productFound)) {
          return productFounds[i].product.length;
        }
      }
      return -1;
    }

    @GET
    @Path("total")
    @Produces(MediaType.TEXT_PLAIN)
    public int getTotalProductFounds() {
      return Consumer.consumeWithJsonp(uriInfo.getBaseUri().toString() +
        "productFounds").length;
    }

    
}
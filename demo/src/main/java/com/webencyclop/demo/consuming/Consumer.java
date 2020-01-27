package com.webencyclop.demo.consuming;

import com.webencyclop.demo.model.Product;
import com.webencyclop.demo.model.ProductFound;
import java.util.List;
import java.util.stream.Collectors;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;


public class Consumer {
    public static ProductFound[] consumeWithJsonb(String targetUrl) {
      Client client = ClientBuilder.newClient();
      Response response = client.target(targetUrl).request().get();
      ProductFound[] productFound = response.readEntity(ProductFound[].class);

      response.close();
      client.close();

      return productFound;
    }

    public static ProductFound[] consumeWithJsonp(String targetUrl) {
      Client client = ClientBuilder.newClient();
      Response response = client.target(targetUrl).request().get();
      JsonArray arr = response.readEntity(JsonArray.class);

      response.close();
      client.close();

      return Consumer.collectProductFound(arr);
    }

    private static ProductFound[] collectProductFound(JsonArray productFoundArr) {
      List<ProductFound> productFounds = productFoundArr.stream().map(productFoundJson -> {
        JsonArray productArr = ((JsonObject) productFoundJson).getJsonArray("products");
        ProductFound productFound = new ProductFound(
          ((JsonObject) productFoundJson).getString("code"),
          Consumer.collectProducts(productArr),
          ((JsonObject) productFoundJson).getString("status_venbose"));
        return productFound;
      }).collect(Collectors.toList());

      return productFounds.toArray(new ProductFound[productFounds.size()]);
    }

    private static Product[] collectProducts(JsonArray productArr) {
      List<Product> products = productArr.stream().map(productJson -> {
        Product product = new Product(
          ((JsonObject) productJson).getString("ingredients"),
          ((JsonObject) productJson).getString("allergens"));
        return product;
      }).collect(Collectors.toList());

      return products.toArray(new Product[products.size()]);
    }
}
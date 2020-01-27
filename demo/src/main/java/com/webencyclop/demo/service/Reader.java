package com.webencyclop.demo.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;

public class Reader {
	
    static String upc = "8000500167113";
    public static JsonArray getProductFound() {
        final String PATH = " https://world.openfoodfacts.org/api/v0/product/8000500167113.json";
        try {
            InputStream fis;
            fis = new FileInputStream(PATH);
            return Json.createReader(fis).readArray();
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist: " + PATH);
            return null;
        }
    }
    
}
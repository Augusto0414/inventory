package com.example.inventory.singleton;

import com.example.inventory.models.Product;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static Inventory instance;
    private List<Product> products;

    private Inventory() {
        products = new ArrayList<>();
    }

    public static synchronized Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}

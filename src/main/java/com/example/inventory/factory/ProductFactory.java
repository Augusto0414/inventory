package com.example.inventory.factory;

import com.example.inventory.models.Product;

public abstract class ProductFactory {
    public abstract Product createProduct(String type, String name, double price);
}

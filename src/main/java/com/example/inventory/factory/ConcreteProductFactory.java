package com.example.inventory.factory;

import com.example.inventory.models.Product;
import com.example.inventory.models.ProductBuilder;

public class ConcreteProductFactory extends ProductFactory {
    @Override
    public Product createProduct(String type, String name, double price) {
        ProductBuilder builder = new ProductBuilder();
        return builder.setName(name).setPrice(price).build(type);
    }
}

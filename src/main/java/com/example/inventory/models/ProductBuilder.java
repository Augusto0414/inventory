package com.example.inventory.models;

public class ProductBuilder {
    private String name;
    private double price;

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Product build(String type) {
        if ("electronics".equalsIgnoreCase(type)) {
            return new ElectronicsProduct(name, price);
        } else if ("clothing".equalsIgnoreCase(type)) {
            return new ClothingProduct(name, price);
        }else if ("furniture".equalsIgnoreCase(type)) {
            return new FurnitureProduct(name, price);
        }
        return null;
    }
}

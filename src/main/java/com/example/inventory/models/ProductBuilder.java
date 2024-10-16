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
        return switch (type.toLowerCase()) {
            case "electronics" -> new ElectronicsProduct(name, price);
            case "clothing" -> new ClothingProduct(name, price);
            default -> null;
        };
    }
}

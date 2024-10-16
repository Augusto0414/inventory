package com.example.inventory.controller;

import com.example.inventory.factory.ConcreteProductFactory;
import com.example.inventory.singleton.Inventory;
import com.example.inventory.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {
    private ConcreteProductFactory productFactory = new ConcreteProductFactory();

    @GetMapping("/products")
    public List<Product> getProducts() {
        return Inventory.getInstance().getProducts();
    }

    @GetMapping("/products/{name}")
    public Product getProductByName(@PathVariable String name) {
        return Inventory.getInstance().getProducts()
                .stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/products")
    public String addProduct(@RequestParam String type, @RequestParam String name, @RequestParam double price) {
        Product product = productFactory.createProduct(type, name, price);
        if (product != null) {
            Inventory.getInstance().addProduct(product);
            return "Producto de tipo '" + type + "' agregado exitosamente: " + name + " a un precio de " + price;
        }
        return "Error: Tipo de producto no reconocido.";
    }
}

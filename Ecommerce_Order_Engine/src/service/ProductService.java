package service;

import model.Product;
import java.util.*;

public class ProductService {
    private Map<String, Product> products = new HashMap<>();

    public void addProduct(Product p) {
        if (products.containsKey(p.getId())) {
            System.out.println("Duplicate Product ID!");
            return;
        }
        products.put(p.getId(), p);
    }

    public Product getProduct(String id) {
        return products.get(id);
    }

    public void viewProducts() {
        products.values().forEach(System.out::println);
    }

    public Collection<Product> getAll() {
        return products.values();
    }
}
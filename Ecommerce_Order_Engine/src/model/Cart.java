package model;

import java.util.*;

public class Cart {
    public Map<String, CartItem> items = new HashMap<>();

    public void addItem(Product p, int qty) {
        items.putIfAbsent(p.getId(), new CartItem(p, 0));
        items.get(p.getId()).quantity += qty;
    }

    public void removeItem(String pid) {
        items.remove(pid);
    }

    public void clear() {
        items.clear();
    }
}
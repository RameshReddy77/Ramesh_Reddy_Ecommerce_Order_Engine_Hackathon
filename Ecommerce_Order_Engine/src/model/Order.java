package model;

import java.util.*;

public class Order {
    public String id;
    public Map<String, CartItem> items;
    public double total;
    public OrderStatus status;

    public Order(String id, Map<String, CartItem> items, double total) {
        this.id = id;
        this.items = items;
        this.total = total;
        this.status = OrderStatus.CREATED;
    }
}
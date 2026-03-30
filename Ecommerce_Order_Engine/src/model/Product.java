package model;

public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public synchronized boolean reduceStock(int qty) {
        if (stock >= qty) {
            stock -= qty;
            return true;
        }
        return false;
    }

    public synchronized void increaseStock(int qty) {
        stock += qty;
    }

    public int getStock() { return stock; }
    public String getId() { return id; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return id + " | " + name + " | ₹" + price + " | Stock: " + stock;
    }
}
package service;

import model.*;
import service.PaymentService;
import util.*;

import java.util.*;

public class OrderService {

    private Map<String, Order> orders = new HashMap<>();
    private PaymentService paymentService = new PaymentService();

    public void placeOrder(String userId, Cart cart) {

        if (cart.items.isEmpty()) {
            System.out.println("Cart empty!");
            return;
        }

        String orderId = IdGenerator.generate();
        Map<String, CartItem> itemsCopy = new HashMap<>(cart.items);

        double total = 0;

        // LOCK + STOCK CHECK
        for (CartItem item : itemsCopy.values()) {
            synchronized (LockManager.getLock(item.product.getId())) {
                if (!item.product.reduceStock(item.quantity)) {
                    System.out.println("Stock not available!");
                    return;
                }
            }
            total += item.product.getPrice() * item.quantity;
        }

        Order order = new Order(orderId, itemsCopy, total);
        order.status = OrderStatus.PENDING_PAYMENT;
        orders.put(orderId, order);

        Logger.log("ORDER CREATED: " + orderId);

        // PAYMENT
        boolean paid = paymentService.processPayment();

        if (!paid) {
            rollback(order);
            order.status = OrderStatus.FAILED;
            System.out.println("Payment Failed!");
            return;
        }

        order.status = OrderStatus.PAID;
        cart.clear();

        Logger.log("PAYMENT SUCCESS: " + orderId);
        System.out.println("Order Placed Successfully!");
    }

    private void rollback(Order order) {
        for (CartItem item : order.items.values()) {
            item.product.increaseStock(item.quantity);
        }
        orders.remove(order.id);
        Logger.log("ROLLBACK DONE for " + order.id);
    }

    public void viewOrders() {
        orders.values().forEach(o ->
            System.out.println(o.id + " | " + o.status + " | ₹" + o.total)
        );
    }
}
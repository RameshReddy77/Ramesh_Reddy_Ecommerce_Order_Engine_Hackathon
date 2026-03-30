package engine;

import model.*;

public class DiscountEngine {

    public static double applyDiscount(Order order) {
        double total = order.total;

        if (total > 1000) total *= 0.9;

        for (CartItem item : order.items.values()) {
            if (item.quantity > 3) {
                total *= 0.95;
            }
        }

        return total;
    }
}
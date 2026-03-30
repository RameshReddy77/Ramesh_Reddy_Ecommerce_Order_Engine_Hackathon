package engine;

import java.util.*;

public class FraudDetector {
    private static Map<String, List<Long>> userOrders = new HashMap<>();

    public static void check(String userId) {
        userOrders.putIfAbsent(userId, new ArrayList<>());
        long now = System.currentTimeMillis();

        userOrders.get(userId).add(now);

        long count = userOrders.get(userId).stream()
                .filter(t -> now - t < 60000)
                .count();

        if (count >= 3) {
            System.out.println("⚠ Fraud Detected!");
        }
    }
}
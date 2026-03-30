package service;

import model.*;
import java.util.*;

public class CartService {
    private Map<String, Cart> userCarts = new HashMap<>();

    public Cart getCart(String userId) {
        userCarts.putIfAbsent(userId, new Cart());
        return userCarts.get(userId);
    }
}
package service;

import java.util.Random;

public class PaymentService {
    public boolean processPayment() {
        return new Random().nextBoolean(); // simulate success/failure
    }
}
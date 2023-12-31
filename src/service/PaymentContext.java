package service;

import model.PaymentStrategy;
import model.User;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(User user) {
        paymentStrategy.pay(user);
    }
}

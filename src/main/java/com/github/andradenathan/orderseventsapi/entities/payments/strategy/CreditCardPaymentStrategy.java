package com.github.andradenathan.orderseventsapi.entities.payments.strategy;

import com.github.andradenathan.orderseventsapi.entities.payments.Payment;
import com.github.andradenathan.orderseventsapi.entities.payments.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public void process(Payment payment) {}

    @Override
    public boolean supports(PaymentMethod method) {
        return PaymentMethod.CREDIT_CARD.equals(method);
    }
}

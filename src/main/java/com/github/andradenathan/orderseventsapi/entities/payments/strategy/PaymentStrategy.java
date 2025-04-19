package com.github.andradenathan.orderseventsapi.entities.payments.strategy;

import com.github.andradenathan.orderseventsapi.entities.payments.Payment;
import com.github.andradenathan.orderseventsapi.entities.payments.PaymentMethod;

public interface PaymentStrategy {
    void process(Payment payment);

    boolean supports(PaymentMethod method);
}

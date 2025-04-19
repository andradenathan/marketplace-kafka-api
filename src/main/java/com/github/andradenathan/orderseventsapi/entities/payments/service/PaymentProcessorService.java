package com.github.andradenathan.orderseventsapi.entities.payments.service;

import com.github.andradenathan.orderseventsapi.entities.payments.Payment;
import com.github.andradenathan.orderseventsapi.entities.payments.strategy.PaymentStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentProcessorService {
    private final List<PaymentStrategy> strategies;

    public PaymentProcessorService(List<PaymentStrategy> strategies) {
        this.strategies = strategies;
    }

    public void process(Payment payment) {
        for (PaymentStrategy strategy : strategies) {
            if (strategy.supports(payment.getMethod())) {
                strategy.process(payment);
                return;
            }
        }
        throw new IllegalArgumentException("No payment strategy found for method: " + payment.getMethod());
    }
}

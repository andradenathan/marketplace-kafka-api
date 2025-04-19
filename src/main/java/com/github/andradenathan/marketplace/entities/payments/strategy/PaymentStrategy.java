package com.github.andradenathan.marketplace.entities.payments.strategy;

import com.github.andradenathan.marketplace.entities.payments.Payment;
import com.github.andradenathan.marketplace.entities.payments.PaymentMethod;

public interface PaymentStrategy {
    void process(Payment payment);

    boolean supports(PaymentMethod method);
}

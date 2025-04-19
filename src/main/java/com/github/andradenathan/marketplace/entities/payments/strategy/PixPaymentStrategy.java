package com.github.andradenathan.marketplace.entities.payments.strategy;

import com.github.andradenathan.marketplace.entities.payments.Payment;
import com.github.andradenathan.marketplace.entities.payments.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class PixPaymentStrategy implements PaymentStrategy{
    @Override
    public void process(Payment payment) {}

    @Override
    public boolean supports(PaymentMethod method) {
        return PaymentMethod.PIX.equals(method);
    }
}

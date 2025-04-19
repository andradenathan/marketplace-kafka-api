package com.github.andradenathan.marketplace.entities.payments.event;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentApprovedEvent {
    private UUID orderId;
    private BigDecimal amount;

    public PaymentApprovedEvent(UUID orderId, BigDecimal amount) {
        this.orderId = orderId;
        this.amount = amount;
    }
}

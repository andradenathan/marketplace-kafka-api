package com.github.andradenathan.orderseventsapi.entities.orders.event;

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

package com.github.andradenathan.orderseventsapi.entities.orders.event;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class CreatedOrderEvent {
    private UUID orderId;
    private String status;
    private BigDecimal amount;

    public CreatedOrderEvent(UUID orderId, String status, BigDecimal amount) {
        this.orderId = orderId;
        this.status = status;
        this.amount = amount;
    }
}

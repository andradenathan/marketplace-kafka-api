package com.github.andradenathan.marketplace.entities.orders;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "orders")
@Getter
public class Order {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;
    private String description;
    private String address;
    private String status;
    private BigDecimal amount;

    public Order(String description, String address, String status, BigDecimal amount) {
        this.description = description;
        this.address = address;
        this.status = status;
        this.amount = amount;
    }
}

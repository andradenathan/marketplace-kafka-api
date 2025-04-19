package com.github.andradenathan.orderseventsapi.entities.payments;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "payments")
public class Payment {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;
    private String method;
    private String status;
    private String transactionId;
    private String orderId;
    private String customerId;
    private String amount;
    private String currency;
    @CreationTimestamp
    private LocalDate createdAt;
}

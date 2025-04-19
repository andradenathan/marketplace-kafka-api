package com.github.andradenathan.marketplace.entities.payments;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Table(name = "payments")
@Setter
@Getter
public class Payment {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;
    private PaymentMethod method;
    private String status;
    private String transactionId;
    private UUID orderId;
    private String customerId;
    private BigDecimal amount;
    private String currency;
    @CreationTimestamp
    private LocalDate createdAt;

    public Payment() {}
}

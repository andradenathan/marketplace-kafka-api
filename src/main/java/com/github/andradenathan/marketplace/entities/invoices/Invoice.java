package com.github.andradenathan.marketplace.entities.invoices;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "invoices")
@Getter
@Setter
public class Invoice {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private UUID orderId;
    private BigDecimal amount;

    @CreationTimestamp
    private LocalDateTime issuedAt;
}

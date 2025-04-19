package com.github.andradenathan.marketplace.entities.notifications;

import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Table(name = "notifications")
public class Notification {
    private Long id;
    private String message;
    private String type;
    @CreationTimestamp
    private LocalDate createdAt;

    public Notification(String message, String type) {
        this.message = message;
        this.type = type;
    }
}

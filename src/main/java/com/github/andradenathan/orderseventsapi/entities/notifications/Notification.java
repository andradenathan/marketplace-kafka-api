package com.github.andradenathan.orderseventsapi.entities.notifications;

import jakarta.persistence.Table;

import java.time.LocalDate;

@Table(name = "notifications")
public class Notification {
    private Long id;
    private String message;
    private String type;
    private LocalDate createdAt;

    public Notification(String message, String type) {
        this.message = message;
        this.type = type;
    }
}

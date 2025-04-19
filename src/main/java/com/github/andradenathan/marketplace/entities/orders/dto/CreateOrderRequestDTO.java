package com.github.andradenathan.marketplace.entities.orders.dto;

import java.math.BigDecimal;

public record CreateOrderRequestDTO(String description, String address, String status, BigDecimal price) {}

package com.github.andradenathan.marketplace.entities.orders.dto;

import com.github.andradenathan.marketplace.entities.orders.Order;

public record CreateOrderResponseDTO(Order order, String message) {}

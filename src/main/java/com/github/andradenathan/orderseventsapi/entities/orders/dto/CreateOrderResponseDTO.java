package com.github.andradenathan.orderseventsapi.entities.orders.dto;

import com.github.andradenathan.orderseventsapi.entities.orders.Order;

public record CreateOrderResponseDTO(Order order, String message) {}

package com.github.andradenathan.orderseventsapi.entities.orders.mapper;

import com.github.andradenathan.orderseventsapi.entities.orders.Order;
import com.github.andradenathan.orderseventsapi.entities.orders.dto.CreateOrderRequestDTO;

public class OrderMapper {
    public static Order toEntity(CreateOrderRequestDTO orderRequestDTO) {
        return new Order(
                orderRequestDTO.description(),
                orderRequestDTO.address(),
                orderRequestDTO.status(),
                orderRequestDTO.price()
        );
    }
}

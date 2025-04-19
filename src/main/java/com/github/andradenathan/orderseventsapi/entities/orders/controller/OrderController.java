package com.github.andradenathan.orderseventsapi.entities.orders.controller;

import com.github.andradenathan.orderseventsapi.entities.orders.dto.CreateOrderRequestDTO;
import com.github.andradenathan.orderseventsapi.entities.orders.dto.CreateOrderResponseDTO;
import com.github.andradenathan.orderseventsapi.entities.orders.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponseDTO> createOrder(
            @RequestBody CreateOrderRequestDTO createOrderRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(createOrderRequestDTO));
    }
}

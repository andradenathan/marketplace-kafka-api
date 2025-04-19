package com.github.andradenathan.orderseventsapi.entities.orders.service;

import com.github.andradenathan.orderseventsapi.entities.orders.Order;
import com.github.andradenathan.orderseventsapi.entities.orders.dto.CreateOrderRequestDTO;
import com.github.andradenathan.orderseventsapi.entities.orders.dto.CreateOrderResponseDTO;
import com.github.andradenathan.orderseventsapi.entities.orders.event.CreatedOrderEvent;
import com.github.andradenathan.orderseventsapi.entities.orders.mapper.OrderMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String CREATED_ORDERS_TOPIC = "created.orders";

    public OrderService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public CreateOrderResponseDTO create(CreateOrderRequestDTO createOrderRequestDTO) {
        Order order = OrderMapper.toEntity(createOrderRequestDTO);

        CreatedOrderEvent event = new CreatedOrderEvent(
                order.getId(),
                order.getStatus(),
                order.getAmount()
        );

        kafkaTemplate.send(CREATED_ORDERS_TOPIC, event);

        return new CreateOrderResponseDTO(order, "Order created successfully");
    }
}

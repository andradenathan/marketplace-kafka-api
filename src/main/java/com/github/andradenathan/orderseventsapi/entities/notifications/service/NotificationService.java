package com.github.andradenathan.orderseventsapi.entities.notifications.service;

import com.github.andradenathan.orderseventsapi.entities.orders.event.PaymentApprovedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @KafkaListener(topics = "payment.approved", groupId = "order-events-group")
    public void notify(PaymentApprovedEvent paymentApprovedEvent) {
        // TODO: Disparar notificação para o customer.
    }
}

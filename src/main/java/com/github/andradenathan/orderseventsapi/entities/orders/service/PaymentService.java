package com.github.andradenathan.orderseventsapi.entities.orders.service;

import com.github.andradenathan.orderseventsapi.entities.orders.event.CreatedOrderEvent;
import com.github.andradenathan.orderseventsapi.entities.orders.event.PaymentApprovedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String PAYMENT_APPROVED_TOPIC = "payment.approved";

    public PaymentService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "created.orders", groupId = "order-events-group")
    public void processPayment(CreatedOrderEvent createdOrderEvent) {
        PaymentApprovedEvent paymentApprovedEvent = new PaymentApprovedEvent(
                createdOrderEvent.getOrderId(),
                createdOrderEvent.getAmount()
        );

        // TODO: Armazenar o pagamento no banco.

        kafkaTemplate.send(PAYMENT_APPROVED_TOPIC, paymentApprovedEvent);
    }
}

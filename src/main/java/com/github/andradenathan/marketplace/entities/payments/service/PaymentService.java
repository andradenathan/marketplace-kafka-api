package com.github.andradenathan.marketplace.entities.payments.service;

import com.github.andradenathan.marketplace.entities.orders.event.CreatedOrderEvent;
import com.github.andradenathan.marketplace.entities.payments.Payment;
import com.github.andradenathan.marketplace.entities.payments.event.PaymentApprovedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final PaymentProcessorService paymentProcessorService;
    private static final String PAYMENT_APPROVED_TOPIC = "payment.approved";

    public PaymentService(KafkaTemplate<String, Object> kafkaTemplate, PaymentProcessorService paymentProcessorService) {
        this.kafkaTemplate = kafkaTemplate;
        this.paymentProcessorService = paymentProcessorService;
    }

    @KafkaListener(topics = "created.orders", groupId = "order-events-group")
    public void processPayment(CreatedOrderEvent createdOrderEvent) {
        Payment payment = new Payment();
        payment.setOrderId(createdOrderEvent.getOrderId());
        payment.setAmount(createdOrderEvent.getAmount());
        payment.setStatus("PENDING");

        paymentProcessorService.process(payment);

        PaymentApprovedEvent paymentApprovedEvent = new PaymentApprovedEvent(
                createdOrderEvent.getOrderId(),
                createdOrderEvent.getAmount()
        );

        // TODO: Armazenar o pagamento no banco.

        kafkaTemplate.send(PAYMENT_APPROVED_TOPIC, paymentApprovedEvent);
    }
}

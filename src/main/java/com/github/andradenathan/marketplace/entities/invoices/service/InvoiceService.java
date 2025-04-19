package com.github.andradenathan.marketplace.entities.invoices.service;

import com.github.andradenathan.marketplace.entities.invoices.event.InvoiceGeneratedEvent;
import com.github.andradenathan.marketplace.entities.payments.event.PaymentApprovedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String INVOICE_GENERATED_TOPIC = "invoice.generated";

    public InvoiceService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "payment.approved", groupId = "order-events-group")
    public void generateInvoice(PaymentApprovedEvent paymentEvent) {
        // TODO: Processar o invoice

        InvoiceGeneratedEvent invoiceGeneratedEvent = new InvoiceGeneratedEvent();

        kafkaTemplate.send(INVOICE_GENERATED_TOPIC, invoiceGeneratedEvent);
    }
}

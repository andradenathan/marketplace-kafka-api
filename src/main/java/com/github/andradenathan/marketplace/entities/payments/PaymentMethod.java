package com.github.andradenathan.marketplace.entities.payments;

public enum PaymentMethod {
    CREDIT_CARD("CREDIT_CARD"),
    DEBIT_CARD("DEBIT_CARD"),
    PIX("PIX"),
    PAYPAL("PAYPAL"),
    STRIPE("STRIPE"),
    BOLETO("BOLETO");

    private final String method;

    PaymentMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}

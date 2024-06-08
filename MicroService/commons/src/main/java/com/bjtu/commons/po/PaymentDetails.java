package com.bjtu.commons.po;

import lombok.Data;

@Data
public class PaymentDetails {
    private String paymentMethod;
    private Double amount;
    private String transactionId;
}


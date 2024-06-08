package com.bjtu.commons.client;

import com.bjtu.commons.po.Payment;
import com.bjtu.commons.po.PaymentDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "payment-service")
public interface PaymentClient {
    @PostMapping("/processPayment")
    void processPayment(Payment payment);
}

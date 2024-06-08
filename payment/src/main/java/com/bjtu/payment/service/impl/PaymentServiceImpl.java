package com.bjtu.payment.service.impl;

import com.bjtu.commons.po.Payment;
import com.bjtu.payment.mapper.PaymentMapper;
import com.bjtu.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public void processPayment(Payment payment) {
        // Save payment details in the database
        paymentMapper.insert(payment);
    }
}

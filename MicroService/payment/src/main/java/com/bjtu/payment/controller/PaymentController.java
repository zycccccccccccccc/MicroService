package com.bjtu.payment.controller;

import com.bjtu.commons.po.Payment;
import com.bjtu.commons.utils.Result;
import com.bjtu.payment.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "支付")
@CrossOrigin("*")
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @ApiOperation("processPayment")
    @PostMapping("/processPayment")
    public Result<String> processPayment(@RequestBody Payment payment) {
        paymentService.processPayment(payment);
        return Result.success("Payment processed successfully");
    }

}

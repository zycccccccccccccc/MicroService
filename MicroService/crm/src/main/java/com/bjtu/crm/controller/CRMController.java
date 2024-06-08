package com.bjtu.crm.controller;

import com.bjtu.commons.dto.OrderRequest;
import com.bjtu.commons.utils.Result;
import com.bjtu.commons.utils.ResultCode;
import com.bjtu.crm.service.CRMService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "crm")
@CrossOrigin("*")
@RestController
public class CRMController {

    @Autowired
    private CRMService crmService;

    @CircuitBreaker(name = "Client", fallbackMethod = "fallbackSchedulePickup")
    @Retry(name = "Client")
    @ApiOperation("placeOrder")
    @PostMapping("/placeOrder")
    public Result<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        crmService.placeOrder(orderRequest);
        return Result.success("Order placed successfully");
    }

    public Result<String> fallbackSchedulePickup(OrderRequest orderRequest, Throwable throwable) {
        // 回退方法逻辑
        return Result.error(ResultCode.FAILED,"Fallback response: " + throwable.getMessage());
    }

}

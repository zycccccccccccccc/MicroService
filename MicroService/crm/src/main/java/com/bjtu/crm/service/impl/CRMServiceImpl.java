package com.bjtu.crm.service.impl;

import com.bjtu.commons.client.LogisticClient;
import com.bjtu.commons.client.PaymentClient;
import com.bjtu.commons.client.WarehouseClient;
import com.bjtu.commons.dto.OrderRequest;
import com.bjtu.commons.po.Order;
import com.bjtu.crm.mapper.OrderMapper;
import com.bjtu.crm.service.CRMService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Slf4j
@Service
@RequiredArgsConstructor
public class CRMServiceImpl implements CRMService {

    @Autowired
    private LogisticClient logisticClient;

    @Autowired
    private WarehouseClient warehouseClient;

    @Autowired
    private PaymentClient paymentClient;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        // Save order information in the database
        Order order = new Order();
        order.setCustomerId(orderRequest.getCustomerId());
        order.setOrderDate(new Date());
        orderMapper.insert(order);

        // Call Logistic Service
        logisticClient.schedulePickup(orderRequest.getLogistic());

        // Call Warehouse Service
        warehouseClient.storeGoods(orderRequest.getWarehouse());

        // Call Payment Service
        paymentClient.processPayment(orderRequest.getPayment());
    }
}

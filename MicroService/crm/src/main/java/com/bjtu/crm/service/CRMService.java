package com.bjtu.crm.service;

import com.bjtu.commons.dto.OrderRequest;

public interface CRMService {


    void placeOrder(OrderRequest orderRequest);
}

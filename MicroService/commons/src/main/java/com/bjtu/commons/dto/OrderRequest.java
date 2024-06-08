package com.bjtu.commons.dto;

import com.bjtu.commons.po.*;
import lombok.Data;

@Data
public class OrderRequest {
    private Long customerId; // 客户ID
    private Logistic logistic; // 物流信息
    private Warehouse warehouse; // 仓储信息
    private Payment payment; // 支付信息
}


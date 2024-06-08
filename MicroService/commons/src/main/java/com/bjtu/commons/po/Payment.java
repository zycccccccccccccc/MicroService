package com.bjtu.commons.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("payment")
@Data
public class Payment {
    private Long id;
    private String paymentMethod;
    private Double amount;
    private String transactionId;
}


package com.bjtu.commons.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("order_info")
@Data
public class Order {
    private Long id;
    private Long customerId;
    private Date orderDate;
}


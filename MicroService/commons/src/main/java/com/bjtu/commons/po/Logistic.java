package com.bjtu.commons.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("logistic")
@Data
public class Logistic {
    private Long id;
    private String pickupLocation;
    private String destination;
    private Date pickupDate;
}


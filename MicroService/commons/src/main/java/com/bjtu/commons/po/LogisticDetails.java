package com.bjtu.commons.po;

import lombok.Data;

import java.util.Date;

@Data
public class LogisticDetails {
    private String pickupLocation;
    private String destination;
    private Date pickupDate;
}


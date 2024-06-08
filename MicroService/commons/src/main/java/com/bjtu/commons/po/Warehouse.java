package com.bjtu.commons.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("warehouse_info")
@Data
public class Warehouse {
    private Long id;
    private String goodsDescription;
    private Integer quantity;
    private String storageLocation;
}


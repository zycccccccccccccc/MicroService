package com.bjtu.warehouse.service.impl;

import com.bjtu.commons.po.Warehouse;
import com.bjtu.commons.po.WarehouseDetails;
import com.bjtu.warehouse.mapper.WarehouseMapper;
import com.bjtu.warehouse.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public void storeGoods(Warehouse warehouse) {
        // Save warehouse details in the database
        warehouseMapper.insert(warehouse);
    }
}

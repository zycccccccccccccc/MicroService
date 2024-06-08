package com.bjtu.warehouse.controller;

import com.bjtu.commons.po.Warehouse;
import com.bjtu.commons.utils.Result;
import com.bjtu.warehouse.service.WarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "仓库")
@CrossOrigin("*")
@RestController
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @ApiOperation("storeGoods")
    @PostMapping("/storeGoods")
    public Result<String> storeGoods(@RequestBody Warehouse warehouse) {
        warehouseService.storeGoods(warehouse);
        return Result.success("Goods stored successfully");
    }

}

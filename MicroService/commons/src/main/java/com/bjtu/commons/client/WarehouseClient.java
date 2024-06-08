package com.bjtu.commons.client;

import com.bjtu.commons.po.Warehouse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "warehouse-service")
public interface WarehouseClient {
    @PostMapping("/storeGoods")
    void storeGoods(Warehouse warehouse);
}

package com.bjtu.commons.client;

import com.bjtu.commons.po.Logistic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "logistic-service",url = "http://localhost:3003")
public interface LogisticClient {

    @PostMapping("/schedulePickup")
    void schedulePickup(Logistic logistic);

}



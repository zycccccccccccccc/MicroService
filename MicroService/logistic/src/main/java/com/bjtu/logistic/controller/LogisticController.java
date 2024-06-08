package com.bjtu.logistic.controller;

import com.bjtu.commons.po.Logistic;
import com.bjtu.commons.utils.Result;
import com.bjtu.logistic.service.LogisticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "物流")
@CrossOrigin("*")
@RestController
public class LogisticController {

    @Autowired
    private LogisticService logisticService;

    @ApiOperation("schedulePickup")
    @PostMapping("/schedulePickup")
    public Result<String> schedulePickup(@RequestBody Logistic logistic) {
        logisticService.schedulePickup(logistic);
        return Result.success("Pickup scheduled successfully");
    }

}

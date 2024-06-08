package com.bjtu.logistic.service.impl;

import com.bjtu.commons.po.Logistic;
import com.bjtu.commons.po.LogisticDetails;
import com.bjtu.logistic.mapper.LogisticMapper;
import com.bjtu.logistic.service.LogisticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class LogisticServiceImpl implements LogisticService {

    @Autowired
    private LogisticMapper logisticMapper;

    @Override
    public void schedulePickup(Logistic logistic) {
        // Save logistic details in the database
        logisticMapper.insert(logistic);
    }
}

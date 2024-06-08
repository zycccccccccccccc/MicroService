package com.bjtu.logistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan(basePackages = "com.bjtu.user.mapper")
@SpringBootApplication(scanBasePackages = "com.bjtu")
public class LogisticApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticApplication.class,args);
    }

}

package com.bjtu.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan(basePackages = "com.bjtu.user.mapper")
@SpringBootApplication(scanBasePackages = "com.bjtu")
public class WarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseApplication.class,args);
    }

}

package com.bjtu.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.bjtu")
public class CRMApplication {

    public static void main(String[] args) {
        SpringApplication.run(CRMApplication.class,args);
    }

}

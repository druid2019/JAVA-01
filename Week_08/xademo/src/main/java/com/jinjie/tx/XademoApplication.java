package com.jinjie.tx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class XademoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(XademoApplication.class, args);
        DbHandleService dbService = context.getBean(DbHandleService.class);
        try {
            dbService.insertXa();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dbService.search();
    }
}

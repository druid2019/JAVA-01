package com.jinjie.beanequip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.jinjie.beanequip.dao")
@SpringBootApplication
public class BeanequipApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanequipApplication.class, args);
    }

}

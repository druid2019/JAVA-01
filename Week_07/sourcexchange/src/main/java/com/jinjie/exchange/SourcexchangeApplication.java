package com.jinjie.exchange;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class SourcexchangeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SourcexchangeApplication.class, args);
        DbChangeService dbChangeService = applicationContext.getAutowireCapableBeanFactory().getBean(DbChangeService.class);
        dbChangeService.send();
        dbChangeService.receive();
    }

    @Bean
    public DataSource ds1() {
        HikariDataSource ds1 = new HikariDataSource();
        ds1.setJdbcUrl("jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false");
        ds1.setUsername("root");
        ds1.setPassword("sea666");
        return ds1;
    }

    @Bean
    public DataSource ds2() {
        HikariDataSource ds2 = new HikariDataSource();
        ds2.setJdbcUrl("jdbc:mysql://localhost:3307/shopping?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false");
        ds2.setUsername("root");
        ds2.setPassword("sea666");
        return ds2;
    }
}

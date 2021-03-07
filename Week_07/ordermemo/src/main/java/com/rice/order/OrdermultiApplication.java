package com.rice.order;

import com.rice.order.dao.OrdersDao;
import com.rice.order.model.Orders;
import com.rice.order.service.OrdersService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@MapperScan("com.rice.order.dao")
@Component
@SpringBootApplication(scanBasePackages = "com.rice.order.*")
public class OrdermultiApplication {

    @Autowired
    private  OrdersService ordersService;

    public static OrdermultiApplication ordermultiApplication;

    @PostConstruct
    public void init() {
        ordermultiApplication = this;
        ordermultiApplication.ordersService = this.ordersService;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrdermultiApplication.class, args);

        List<Orders> ordersList = new ArrayList<>();
        Orders orders = new Orders();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {

            orders.setUserId(BigInteger.valueOf(i+1));
            orders.setAccount((float) i);
            orders.setOrderState(1);
            orders.setPayType(1);
            /*Orders orders = Orders.builder()
                    .userId(BigInteger.valueOf(i+1))
                    .account((float) i)
                    .orderState(1)
                    .payType(1).build();*/
            ordersList.add(orders);
            if ((i+1) % 100000 == 0) {
                ordermultiApplication.ordersService.batchSubmit(ordersList);
                ordersList.clear();
            }
        }



        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");
//        System.out.println(ordersList);

    }

}

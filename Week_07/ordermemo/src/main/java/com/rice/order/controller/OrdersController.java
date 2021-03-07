package com.rice.order.controller;

import com.rice.order.model.Orders;
import com.rice.order.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/3/6 22:56
 * @Description ${description}
 */
@Slf4j
@RestController
@RequestMapping("v1")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping(value = "/listById")
    public List<Orders> findById(BigInteger orderId) {
        List<Orders> ordersList = ordersService.findById(orderId);
        return ordersList;
    }

    @PostMapping("/orders/add")
    public void batchSubmit(List<Orders> list) {
        ordersService.batchSubmit(list);
    }

}

package com.rice.order.service.impl;

import com.rice.order.dao.OrdersDao;
import com.rice.order.model.Orders;
import com.rice.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/3/6 22:47
 * @Description ${description}
 */
@Service
public class OrderServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    @Transactional
    public void batchSubmit(List<Orders> list) {
         ordersDao.batchSubmit(list);
    }

    @Override
    public List<Orders> findById(BigInteger orderId) {
        return ordersDao.findById(orderId);
    }
}

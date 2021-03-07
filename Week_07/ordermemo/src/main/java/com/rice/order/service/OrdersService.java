package com.rice.order.service;

import com.rice.order.model.Orders;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/3/6 22:42
 * @Description ${description}
 */
public interface OrdersService {

    /**
     *  批量提交订单
     * @param list
     * @create
     */
    void batchSubmit(List<Orders> list);

    /**
     *  根据订单编号查询
     * @param orderId
     * @return
     * @create
     */
    List<Orders> findById(BigInteger orderId);
}

package com.rice.order.dao;

import com.rice.order.model.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/3/6 22:39
 * @Description ${description}
 */
@Mapper
public interface OrdersDao {

    /**
     *  批量提交订单
     * @param list
     * @create
     */
    void batchSubmit(@Param("data") List<Orders> list);
    
    /**
     *  根据订单编号查询
     * @param orderId 
     * @return  
     * @create  
     */
    List<Orders> findById(@Param("orderId") BigInteger orderId);
    
}

package com.rice.order.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/3/6 22:12
 * @Description 订单
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     *  主键id
     */
    private BigInteger orderId;

    /**
     *  用户id
     */
    private BigInteger userId;

    /**
     *  支付金额
     */
    private Float account;

    /**
     *  订单状态
     */
    private Integer orderState;

    /**
     *  支付类型
     */
    private Integer payType;

    /**
     *  创建时间
     */
    private Timestamp createTime;

    /**
     *  更新时间
     */
    private Timestamp updateTime;
}

package com.rice.order.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/3/6 22:12
 * @Description 订单详情
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetail {
    /**
     *  主键id
     */
    @NotNull(message = "id不能为空")
    private BigInteger id;

    /**
     *  商品id
     */
    private BigInteger goodsId;

    /**
     *  数量
     */
    private Integer num;

    /**
     *  价格
     */
    private Float price;

    /**
     *  商品名称
     */
    private String goodsName;

    /**
     *  创建时间
     */
    private Timestamp createTime;

    /**
     *  更新时间
     */
    private Timestamp updateTime;
}

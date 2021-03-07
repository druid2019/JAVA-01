package com.rice.order.model;

import javax.validation.constraints.NotNull;

import lombok.*;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/3/6 21:39
 * @Description 商品信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Goods {

    @NotNull(message = "id不能为空")
    /**
     *
     * 主键id
     */
    private BigInteger id;

    /**
     * 商品编号
     */
    private BigInteger goodsId;

    /**
     * 商品编号
     */
    private String goodsName;

    /**
     * 商品类型
     */
    private String goodsType;

    /**
     * 商品重量
     */
    private String weight;

    /**
     * 商品价格
     */
    private Float price;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;
}

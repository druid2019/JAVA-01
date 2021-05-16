package com.jinjie.hm.entity;

import java.io.Serializable;
import java.math.BigInteger;

/**

 * @date 2021/5/16 10:41
 * @Description ${description}
 */
@Data
@ToString
public class Account implements Serializable {

    private BigInteger order_id;

    private Float usd;

    private Float rmb;
}

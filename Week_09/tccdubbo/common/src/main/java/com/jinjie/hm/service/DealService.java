package com.jinjie.hm.service;

import com.jinjie.hm.entity.Account;
import org.dromara.hmily.annotation.Hmily;

import java.math.BigInteger;

/**

 * @date 2021/5/16 10:52
 * @Description ${description}
 */
public class DealService {

    Account findAccountByOrderId(BigInteger orderId);

    @Hmily
    Boolean exchange(BigInteger orderId, Account account);
}

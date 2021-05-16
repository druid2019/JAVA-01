package com.jinjie.hm.controller;

/**

 * @date 2021/5/16 11:13
 * @Description ${description}
 */

import com.jinjie.hm.entity.Account;
import com.jinjie.hm.service.DealService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

@RestController
public class DealController {
    @DubboReference
    private DealService dealService;

    @PostMapping("findAccountByOrder")
    public Account findAccountByOrder(@RequestBody BigInteger orderId) {
        return dealService.findAccountByOrder(orderId);
    }

    @PostMapping("accountUsd")
    public Boolean accountUsd(@RequestBody Map<String, Object> map) {
        long orderId = (Integer) map.get("orderId");
        BigDecimal money = BigDecimal.valueOf((Double) map.get("money"));
        Account account = new Account();
        account.setUsd(money);
        return dealService.accountMoney(orderId, account);
    }

    @PostMapping("accountRmb")
    public Boolean accountRmb(@RequestBody Map<String, Object> map) {
        long orderId = (Integer) map.get("orderId");
        BigDecimal money = BigDecimal.valueOf((Double) map.get("money"));
        Account account = new Account();
        account.setRmb(money);
        return dealService.accountMoney(orderId, account);
    }
}

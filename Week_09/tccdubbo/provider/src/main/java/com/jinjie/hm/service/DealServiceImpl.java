package com.jinjie.hm.service;

/**
 * @date 2021/5/16 11:48
 * @Description ${description}
 */

import com.jinjie.hm.entity.Account;
import com.jinjie.hm.entity.FreezonAccount;
import com.jinjie.hm.service.DealService;
import com.jinjie.hm.mapper.AccountMapper;
import com.jinjie.hm.mapper.FreezonAccountMapper;

import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@DubboService
public class DealServiceImpl implements DealService {
    AccountMapper accountMapper;
    FreezonAccountMapper freezonAccountMapper;

    public TransMoneyServiceImpl(AccountMapper accountMapper, FreezonAccountMapper freezonAccountMapper) {
        this.accountMapper = accountMapper;
        this.freezonAccountMapper = freezonAccountMapper;
    }

    @Override
    public Account findAccountByUserId(long orderId) {
        return accountMapper.findByUserId(orderId);
    }

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public Boolean accountMoney(long orderId, Account account) {
        BigDecimal usd = account.getUsd();
        BigDecimal rmb = account.getRmb();
        boolean result = true;
        if (usd != null) {
            result = accountMapper.subUsd(orderId, usd) > 0 && freezonAccountMapper.addUsd(orderId, usd) > 0;
        }
        if (rmb != null) {
            result = result && accountMapper.subRmb(orderId, rmb) > 0 && freezonAccountMapper.addRmb(orderId, rmb) > 0;
        }
        return result;
    }

    public boolean confirm(long orderId, Account account) {
        return addMoney(orderId, account) && clearFreeze(orderId, account);
    }

    public boolean cancel(long orderId, Account account) {
        return addMoney(orderId, account) && clearFreeze(orderId, account);
    }

    private boolean clearFreeze(long orderId, Account account) {
        BigDecimal usd = account.getUsd();
        BigDecimal rmb = account.getRmb();
        boolean result = true;
        if (usd != null) {
            result = freezonAccountMapper.subUsd(orderId, usd) > 0;
        }
        if (rmb != null) {
            result = result && freezonAccountMapper.subRmb(orderId, rmb) > 0;
        }
        return result;
    }

    private boolean addMoney(long orderId, Account account) {
        BigDecimal usd = account.getUsd();
        BigDecimal rmb = account.getRmb();
        boolean result = true;
        if (usd != null) {
            result = accountMapper.addRmb(orderId, usd.multiply(BigDecimal.valueOf(7))) > 0;
        }
        if (rmb != null) {
            result = result && accountMapper.addUsd(orderId, rmb.divide(BigDecimal.valueOf(7))) > 0;
        }
        return result;
    }
}

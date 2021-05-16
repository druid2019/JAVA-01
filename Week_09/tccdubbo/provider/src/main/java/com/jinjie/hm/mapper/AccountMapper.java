package com.jinjie.hm.mapper;

/**

 * @date 2021/5/16 11:30
 * @Description ${description}
 */

import com.jinjie.hm.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class AccountMapper {
    @Select("select * from account where order_id = #{orderId}")
    Account findByOrderId(long orderId);

    @Update("update account set usd = usd - #{money} where order_id = #{orderId}")
    int subUsd(@Param("orderId") long orderId, @Param("money") BigDecimal money);

    @Update("update account set usd = usd + #{money} where order_id = #{orderId}")
    int addUsd(@Param("orderId") long orderId, @Param("money") BigDecimal money);

    @Update("update account set rmb = rmb - #{money} where order_id = #{orderId}")
    int subRmb(@Param("orderId") long orderId, @Param("money") BigDecimal money);

    @Update("update account set rmb = rmb + #{money} where order_id = #{orderId}")
    int addRmb(@Param("orderId") long orderId, @Param("money") BigDecimal money);
}
}

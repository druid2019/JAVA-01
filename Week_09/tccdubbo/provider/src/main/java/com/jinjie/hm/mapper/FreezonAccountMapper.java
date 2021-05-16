package com.jinjie.hm.mapper;

/**

 * @date 2021/5/16 11:31
 * @Description ${description}
 */

import com.jinjie.hm.entity.FreezonAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


public class FreezonAccountMapper {

    @Select("select * from freeze_account where user_id = #{orderId}")
    FreezeAccount findByOrderId(long orderId);

    @Update("update freeze_account set usd = usd - #{money} where user_id = #{orderId}")
    int subUsd(@Param("orderId") long orderId, @Param("money") BigDecimal money);

    @Update("update freeze_account set usd = usd + #{money} where user_id = #{orderId}")
    int addUsd(@Param("orderId") long orderId, @Param("money") BigDecimal money);

    @Update("update freeze_account set rmb = rmb - #{money} where user_id = #{orderId}")
    int subRmb(@Param("orderId") long orderId, @Param("money") BigDecimal money);

    @Update("update freeze_account set rmb = rmb + #{money} where user_id = #{orderId}")
    int addRmb(@Param("orderId") long orderId, @Param("money") BigDecimal money);
}

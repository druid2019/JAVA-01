package com.rice.order.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/3/6 21:58
 * @Description 用户
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    /**
     *  主键id
     */
    @NotNull(message = "id不能为空")
    private BigInteger id;

    /**
     *  用户id
     */
    private BigInteger userId;

    /**
     *  用户名称
     */
    private String userName;

    /**
     *  密码
     */
    private String password;

    /**
     *  昵称
     */
    private String nickName;

    /**
     *  证件号码
     */
    private String certificateNum;

    /**
     *  操作者
     */
    private String operateUser;

    /**
     *  创建时间
     */
    private Timestamp createTime;

    /**
     *  更新时间
     */
    private Timestamp updateTime;
}

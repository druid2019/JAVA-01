package com.jinjie.autoequip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/20 11:23
 * @Description ${description}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    // 学号
    private String id;

    // 姓名
    private String name;

    // 性别
    private String sex;

}

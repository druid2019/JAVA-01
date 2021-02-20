package com.jinjie.beanequip.model;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/19 20:44
 * @Description ${description}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @NotNull(message = "libCode不能为空")
    private String id;

    private String name;

    private String sex;

}

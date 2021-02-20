package com.jinjie.autoequip;

import lombok.Data;

import java.util.List;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/20 11:29
 * @Description ${description}
 */
@Data
public class Klass {
    List<Student> students;

    public void dong() {
        System.out.println(this.getStudents());
    }
}

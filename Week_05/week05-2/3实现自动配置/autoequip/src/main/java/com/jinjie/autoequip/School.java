package com.jinjie.autoequip;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/20 11:31
 * @Description ${description}
 */
@Data
public class School implements ISchool{

    @Autowired(required = true)
    Klass class1;

    @Autowired
    Student student001;

    @Override
    public void ding() {
        System.out.println("Class1 hava " + this.class1.getStudents().size() + " students and one is " + this.student001);
    }
}

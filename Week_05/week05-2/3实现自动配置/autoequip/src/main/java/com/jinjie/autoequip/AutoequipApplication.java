package com.jinjie.autoequip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AutoequipApplication {

    public static void main(String[] args) {
        Student a = new Student();
        a.setId("1");
        a.setName("zhangsan");
        a.setSex("female");

        System.out.println(a);

        Student student001 = new Student();
        student001.setId("001");
        student001.setName("zhangsan001");
        student001.setSex("female");

        List<Student> s = new ArrayList<>();
        s.add(student001);
        Klass class1 = new Klass();
        class1.setStudents(s);
//        System.out.println(class1);
        class1.dong();

        School school = new School();
        school.setClass1(class1);
        school.setStudent001(student001);
        school.ding();
        SpringApplication.run(AutoequipApplication.class, args);
    }

}

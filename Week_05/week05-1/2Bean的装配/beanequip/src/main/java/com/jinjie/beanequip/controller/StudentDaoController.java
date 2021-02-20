package com.jinjie.beanequip.controller;

import com.jinjie.beanequip.model.Student;
import com.jinjie.beanequip.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/19 21:58
 * @Description ${description}
 */
@RestController
@RequestMapping("v1")
public class StudentDaoController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/listById")
    public List<Student> findById(String id) {
        List<Student> stuList  = studentService.findById(id);
        return stuList;
    }

}

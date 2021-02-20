package com.jinjie.beanequip.service;

import com.jinjie.beanequip.model.Student;

import java.util.List;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/19 21:44
 * @Description 学生表列表接口
 */
public interface StudentService {
    /**
     * 
     * @param id 
     * @return
     * @create  
     */
    List<Student> findById(String id);
}

package com.jinjie.beanequip.service.impl;

import com.jinjie.beanequip.dao.StudentDao;
import com.jinjie.beanequip.model.Student;
import com.jinjie.beanequip.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/19 21:43
 * @Description ${description}
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findById(String id) {
        return studentDao.findById(id);
    }
}

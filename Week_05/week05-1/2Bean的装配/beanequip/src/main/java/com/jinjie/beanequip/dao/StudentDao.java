package com.jinjie.beanequip.dao;

import com.jinjie.beanequip.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/19 20:52
 * @Description ${description}
 */
@Mapper
public interface StudentDao {
    /**
     * 
     * @param id 
     * @return
     * @create  
     */
    List<Student> findById(@Param("id") String id);
}

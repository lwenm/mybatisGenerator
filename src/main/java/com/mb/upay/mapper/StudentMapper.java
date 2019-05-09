package com.mb.upay.mapper;

import com.mb.upay.model.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    /**
     * 根据传入属性查询
     * @param student
     * @return
     */
    List<Student> selectByStudentSelective(Student student);

    /**
     * 根据Id查找 无ID则根据名字查找
     * @param record
     * @return
     */
    Student selectByIdOrName(Student record);
}
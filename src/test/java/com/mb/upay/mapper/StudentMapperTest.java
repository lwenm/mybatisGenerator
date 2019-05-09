package com.mb.upay.mapper;

import com.mb.upay.model.Student;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Author:lwenm
 * Description:
 * Date:2019/3/6
 * Time:10:02
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void selectByStudentSelective() throws Exception {

        Student search = new Student();
        search.setName("明");

        System.out.println("只有名字时的查询");
        List<Student> studentsByName = studentMapper.selectByStudentSelective(search);
        for (int i = 0; i < studentsByName.size(); i++) {
            System.out.println(ToStringBuilder.reflectionToString(studentsByName.get(i), ToStringStyle.MULTI_LINE_STYLE));
        }

        search.setName(null);
        search.setSex((byte) 1);
        System.out.println("只有性别时的查询");
        List<Student> studentsBySex = studentMapper.selectByStudentSelective(search);
        for (int i = 0; i < studentsBySex.size(); i++) {
            System.out.println(ToStringBuilder.reflectionToString(studentsBySex.get(i), ToStringStyle.MULTI_LINE_STYLE));
        }

        System.out.println("姓名和性别同时存在的查询");
        search.setName("明");
        List<Student> studentsByNameAndSex = studentMapper.selectByStudentSelective(search);
        for (int i = 0; i < studentsByNameAndSex.size(); i++) {
            System.out.println(ToStringBuilder.reflectionToString(studentsByNameAndSex.get(i), ToStringStyle.MULTI_LINE_STYLE));
        }

    }


    @Test
    public void TDmo(){
        Student student = new Student();
        student.setName("4");
        student.setStudentId(1);

        Student studentById = studentMapper.selectByIdOrName(student);
        System.out.println("有 ID 则根据 ID 获取");
        System.out.println(ToStringBuilder.reflectionToString(studentById, ToStringStyle.MULTI_LINE_STYLE));


         studentById = studentMapper.selectByIdOrName(student);
        System.out.println("有 ID 则根据 ID 获取2");
        System.out.println(ToStringBuilder.reflectionToString(studentById, ToStringStyle.MULTI_LINE_STYLE));

        student.setStudentId(null);
        Student studentByName = studentMapper.selectByIdOrName(student);
        System.out.println("没有 ID 则根据 name 获取");
        System.out.println(ToStringBuilder.reflectionToString(studentByName, ToStringStyle.MULTI_LINE_STYLE));

        student.setName(null);
        Student studentNull = studentMapper.selectByIdOrName(student);
        System.out.println("没有 ID 和 name, 返回 null");
        Assert.assertNull(studentNull);

    }

}
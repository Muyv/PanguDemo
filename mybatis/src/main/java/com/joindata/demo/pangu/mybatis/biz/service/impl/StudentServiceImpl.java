package com.joindata.demo.pangu.mybatis.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joindata.demo.pangu.mybatis.biz.service.StudentService;
import com.joindata.demo.pangu.mybatis.dao.StudentMapper;
import com.joindata.demo.pangu.mybatis.entity.Student;
import com.joindata.demo.pangu.mybatis.entity.StudentList;
import com.joindata.inf.common.sterotype.jdbc.annotation.Datasource;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentMapper mapper;

    @Override
    @Datasource("ds_student") // 数据源切换可以加到方法上
    public Student getStudent(Long id)
    {
        return mapper.get(id);
    }

    @Override
    @Datasource("ds_student") // 数据源切换可以加到方法上
    public StudentList listStudent()
    {
        return mapper.getAll();
    }

    @Override
    @Datasource("ds_student") // 数据源切换可以加到方法上
    public Long createStudent(Student student)
    {
        mapper.insert(student);
        return student.getId();
    }

    @Override
    @Datasource("ds_student") // 数据源切换可以加到方法上
    public void modifyStudent(Student student)
    {
        mapper.update(student);
    }

    @Override
    @Datasource("ds_student") // 数据源切换可以加到方法上
    public void removeStudent(Long id)
    {
        mapper.setDeleted(id);
    }

}

package com.joindata.demo.pangu.mybatis.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joindata.demo.pangu.mybatis.biz.service.TeacherService;
import com.joindata.demo.pangu.mybatis.dao.TeacherMapper;
import com.joindata.demo.pangu.mybatis.entity.Teacher;
import com.joindata.demo.pangu.mybatis.entity.TeacherList;
import com.joindata.inf.common.sterotype.jdbc.annotation.Datasource;

@Service
@Datasource("ds_teacher") // 数据源切换可以加到类上，下面所有的方法都会使用该数据源
public class TeacherServiceImpl implements TeacherService
{
    @Autowired
    private TeacherMapper mapper;

    @Override
    public Teacher getTeacher(Long id)
    {
        return mapper.get(id);
    }

    @Override
    public TeacherList listTeacher()
    {
        return mapper.getAll();
    }

    @Override
    public Long createTeacher(Teacher teacher)
    {
        mapper.insert(teacher);
        return teacher.getId();
    }

    @Override
    public void modifyTeacher(Teacher teacher)
    {
        mapper.update(teacher);
    }

    @Override
    public void removeTeacher(Long id)
    {
        mapper.setDeleted(id);
    }

}

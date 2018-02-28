package com.joindata.demo.pangu.mybatis.biz.service;

import com.joindata.demo.pangu.mybatis.entity.Teacher;
import com.joindata.demo.pangu.mybatis.entity.TeacherList;

public interface TeacherService
{
    Teacher getTeacher(Long id);

    TeacherList listTeacher();

    Long createTeacher(Teacher teacher);

    void modifyTeacher(Teacher teacher);

    void removeTeacher(Long id);
}

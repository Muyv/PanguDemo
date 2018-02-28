package com.joindata.demo.pangu.mybatis.biz.service;

import com.joindata.demo.pangu.mybatis.entity.Student;
import com.joindata.demo.pangu.mybatis.entity.StudentList;

public interface StudentService
{
    Student getStudent(Long id);

    StudentList listStudent();

    Long createStudent(Student student);

    void modifyStudent(Student student);

    void removeStudent(Long id);
}

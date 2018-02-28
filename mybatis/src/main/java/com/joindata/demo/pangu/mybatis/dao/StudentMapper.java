package com.joindata.demo.pangu.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.joindata.demo.pangu.mybatis.entity.Student;
import com.joindata.demo.pangu.mybatis.entity.StudentList;

@Repository
public interface StudentMapper
{
    Student get(@Param("id") Long id);

    StudentList getAll();

    void insert(Student student);

    void update(Student student);

    void setDeleted(@Param("id") Long id);
}
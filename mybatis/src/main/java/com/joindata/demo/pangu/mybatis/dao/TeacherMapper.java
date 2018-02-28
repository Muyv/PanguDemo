package com.joindata.demo.pangu.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.joindata.demo.pangu.mybatis.entity.Teacher;
import com.joindata.demo.pangu.mybatis.entity.TeacherList;

@Repository
public interface TeacherMapper
{
    Teacher get(@Param("id") Long id);

    TeacherList getAll();

    void insert(Teacher teacher);

    void update(Teacher teacher);

    void setDeleted(@Param("id") Long id);
}
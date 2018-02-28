package com.joindata.demo.pangu.mybatis.entity;

import com.joindata.inf.common.basic.entities.DateTime;

import lombok.Data;

@Data
public class Teacher
{
    private Long id;

    private String name;

    private String gender;

    private Integer age;

    private DateTime created;

    private DateTime updated;
}

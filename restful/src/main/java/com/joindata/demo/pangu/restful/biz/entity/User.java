package com.joindata.demo.pangu.restful.biz.entity;

import com.joindata.demo.pangu.restful.enums.GENDER;

import lombok.Data;

@Data
public class User
{
    private Long id;

    private String name;

    private int age;

    private GENDER gender;
}

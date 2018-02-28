package com.joindata.demo.pangu.restful.biz.param;

import com.joindata.demo.pangu.restful.enums.GENDER;

import lombok.Data;

@Data
public class UserModifyParam
{
    private String name;

    private int age;

    private GENDER gender;
}

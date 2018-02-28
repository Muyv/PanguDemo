package com.joindata.demo.pangu.rabbitmq.biz.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User implements Serializable
{
    private static final long serialVersionUID = -7558027388775779577L;

    private String name;

    private String gender;

    private int age;
}

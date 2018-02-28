package com.joindata.demo.pangu.rabbitmq.biz.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Contact implements Serializable
{
    private static final long serialVersionUID = 4264674429518001456L;

    private String userId;

    private String name;

    private String[] phone;

    private String email;
}

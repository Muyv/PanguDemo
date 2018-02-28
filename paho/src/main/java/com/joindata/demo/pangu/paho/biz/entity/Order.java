package com.joindata.demo.pangu.paho.biz.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Order implements Serializable
{
    private static final long serialVersionUID = -4653324143173604338L;

    private String id;

    private String name;

    private String tableName;

    private float price;
}

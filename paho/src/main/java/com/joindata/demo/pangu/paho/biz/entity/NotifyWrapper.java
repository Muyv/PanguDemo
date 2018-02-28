package com.joindata.demo.pangu.paho.biz.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class NotifyWrapper implements Serializable
{
    private static final long serialVersionUID = 735752786440123333L;

    private String message;
}

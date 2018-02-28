package com.joindata.demo.pangu.camunda.biz.exception;

import com.joindata.inf.common.basic.entities.ErrorEntity;
import com.joindata.inf.common.basic.exceptions.BizException;

public class UserNotFoundException extends BizException
{
    public UserNotFoundException(String message)
    {
        super(message);
    }

    private static final long serialVersionUID = -8158052377546917628L;

    @Override
    public ErrorEntity getErrorEntity()
    {
        return ErrorEntity.define(1000, "找不到用户");
    }

}

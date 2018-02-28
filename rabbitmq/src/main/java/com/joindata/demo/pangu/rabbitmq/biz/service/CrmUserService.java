package com.joindata.demo.pangu.rabbitmq.biz.service;

import org.springframework.stereotype.Service;

import com.joindata.demo.pangu.rabbitmq.biz.entity.User;
import com.joindata.inf.common.util.log.Logger;

@Service
public class CrmUserService
{
    private static final Logger log = Logger.get();

    public void saveUser(User user)
    {
        log.info("保存用户: {}", user);
    }
}

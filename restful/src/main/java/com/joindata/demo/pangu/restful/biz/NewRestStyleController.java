package com.joindata.demo.pangu.restful.biz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.demo.pangu.restful.biz.entity.User;
import com.joindata.demo.pangu.restful.enums.GENDER;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/newrest")
public class NewRestStyleController
{
    @ApiOperation("测试新的 REST 风格写法")
    @GetMapping("/")
    public User testNewRest()
    {
        User user = new User();
        user.setAge(19);
        user.setGender(GENDER.MALE);
        user.setName("拉登");
        user.setId(System.currentTimeMillis());

        return user;
    }
}

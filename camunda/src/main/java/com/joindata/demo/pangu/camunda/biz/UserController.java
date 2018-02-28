package com.joindata.demo.pangu.camunda.biz;

import java.util.List;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.inf.boot.sterotype.RestResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private IdentityService identityService;

    @ApiOperation("列出用户")
    @GetMapping("/")
    public RestResponse<List<User>> listUser()
    {
        return RestResponse.success(identityService.createUserQuery().list());
    }

    @ApiOperation("列出用户")
    @GetMapping("/count")
    public RestResponse<Long> getUser()
    {
        return RestResponse.success(identityService.createUserQuery().count());
    }

}
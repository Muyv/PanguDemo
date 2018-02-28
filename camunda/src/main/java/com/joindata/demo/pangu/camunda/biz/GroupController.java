package com.joindata.demo.pangu.camunda.biz;

import java.util.List;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.identity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.inf.boot.sterotype.RestResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/group")
public class GroupController
{
    @Autowired
    private IdentityService identityService;

    @ApiOperation("列出组")
    @GetMapping("/")
    public RestResponse<List<Group>> listUser()
    {
        return RestResponse.success(identityService.createGroupQuery().orderByGroupName().asc().list());
    }

}
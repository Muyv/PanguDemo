package com.joindata.demo.pangu.restful.biz;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.demo.pangu.restful.biz.entity.User;
import com.joindata.demo.pangu.restful.biz.entity.UserList;
import com.joindata.demo.pangu.restful.biz.exception.UserNotFoundException;
import com.joindata.demo.pangu.restful.biz.param.UserModifyParam;
import com.joindata.demo.pangu.restful.enums.GENDER;
import com.joindata.inf.boot.sterotype.RestResponse;
import com.joindata.inf.common.basic.entities.PageCalc;
import com.joindata.inf.common.util.basic.CollectionUtil;
import com.joindata.inf.common.util.tools.RandomUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/user")
public class Controller
{
    @ApiOperation("列出用户")
    @GetMapping("/")
    public RestResponse<UserList> listUser(@ApiParam("页码") @RequestParam int page)
    {
        // 页码计算器
        PageCalc pageCalc = new PageCalc(250, 10);

        // 生成用户列表
        UserList userList = new UserList();
        for(int i = pageCalc.getStart(page); i < pageCalc.getEnd(page); i++)
        {
            User user = new User();
            user.setId((long)i);
            user.setName(RandomUtil.randomAlphabetic(5));
            user.setAge(RandomUtil.randomInt(5, 25));
            user.setGender(RandomUtil.randomInt(0, 12) % 2 == 0 ? GENDER.MALE : GENDER.FEMALE);
            userList.add(user);
        }

        // 返回用户列表并加上页码数据
        return RestResponse.success(userList, CollectionUtil.newMap("pageInfo", pageCalc));
    }

    @ApiOperation("获取用户")
    @GetMapping("/{id}")
    public RestResponse<User> getUser(@ApiParam("用户 ID") @PathVariable long id)
    {
        User user = new User();
        user.setId(id);
        user.setName(RandomUtil.randomAlphabetic(5));
        user.setAge(RandomUtil.randomInt(5, 25));
        user.setGender(RandomUtil.randomInt(0, 12) % 2 == 0 ? GENDER.MALE : GENDER.FEMALE);

        return RestResponse.success(user);
    }

    @ApiOperation("修改用户")
    @PutMapping("/{id}")
    public RestResponse<Long> modifyUser(@ApiParam("用户 ID") @PathVariable long id, @RequestBody UserModifyParam param)
    {
        // 调用 Service 修改用户

        // 随机抛出用户找不到异常
        if(RandomUtil.randomInt(0, 2000) % 12 == 0)
        {
            throw new UserNotFoundException("找不到用户");
        }

        // 这里尽管返回成功，如果出现异常，框架会自动包装好错误消息并返回客户端
        return RestResponse.success(id, "用户 " + id + " 已更新");
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public RestResponse<Long> removeUser(@ApiParam("用户 ID") @PathVariable long id)
    {
        // 调用 Service 删除用户

        return RestResponse.success(id, "用户 " + id + " 已删除");
    }
}

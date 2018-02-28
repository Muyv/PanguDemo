package com.joindata.demo.pangu.mybatis.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.demo.pangu.mybatis.biz.service.TeacherService;
import com.joindata.demo.pangu.mybatis.entity.Teacher;
import com.joindata.demo.pangu.mybatis.entity.TeacherList;
import com.joindata.inf.boot.sterotype.RestResponse;

@RestController
@RequestMapping("/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService service;

    @GetMapping("/")
    public RestResponse<TeacherList> listTeacher()
    {
        return RestResponse.success(service.listTeacher());
    }

    @GetMapping("/{id}")
    public RestResponse<Teacher> getTeacher(@PathVariable Long id)
    {
        return RestResponse.success(service.getTeacher(id));
    }

    @PostMapping("/$")
    public RestResponse<Long> createTeacher(@RequestBody Teacher teacher)
    {
        Long id = service.createTeacher(teacher);
        return RestResponse.success(id);
    }

    @PutMapping("/{id}")
    public RestResponse<Void> modifyTeacher(@PathVariable Long id, @RequestBody Teacher teacher)
    {
        service.modifyTeacher(teacher);

        return RestResponse.success();
    }

    @DeleteMapping("/{id}")
    public RestResponse<Void> removeTeacher(@PathVariable Long id)
    {
        service.removeTeacher(id);
        return RestResponse.success();
    }
}

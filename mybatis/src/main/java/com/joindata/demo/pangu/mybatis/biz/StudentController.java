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

import com.joindata.demo.pangu.mybatis.biz.service.StudentService;
import com.joindata.demo.pangu.mybatis.entity.Student;
import com.joindata.demo.pangu.mybatis.entity.StudentList;
import com.joindata.inf.boot.sterotype.RestResponse;

@RestController
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    private StudentService service;

    @GetMapping("/")
    public RestResponse<StudentList> listStudent()
    {
        return RestResponse.success(service.listStudent());
    }

    @GetMapping("/{id}")
    public RestResponse<Student> getStudent(@PathVariable Long id)
    {
        return RestResponse.success(service.getStudent(id));
    }

    @PostMapping("/$")
    public RestResponse<Long> createStudent(@RequestBody Student student)
    {
        Long id = service.createStudent(student);
        return RestResponse.success(id);
    }

    @PutMapping("/{id}")
    public RestResponse<Void> modifyStudent(@PathVariable Long id, @RequestBody Student student)
    {
        service.modifyStudent(student);

        return RestResponse.success();
    }

    @DeleteMapping("/{id}")
    public RestResponse<Void> removeStudent(@PathVariable Long id)
    {
        service.removeStudent(id);
        return RestResponse.success();
    }
}

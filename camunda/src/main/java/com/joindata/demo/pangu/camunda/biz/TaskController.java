package com.joindata.demo.pangu.camunda.biz;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.inf.boot.sterotype.RestResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/task")
public class TaskController
{
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @PostMapping("/")
    public RestResponse<String> startProcess()
    {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("PublishProcess");

        return RestResponse.success(instance.getId());
    }

    @PutMapping("/{taskId}/_complete")
    public void completeProcess(@PathVariable String taskId)
    {
        taskService.complete(taskId);
    }

    @ApiOperation("列出任务")
    @GetMapping("/")
    public RestResponse<List<String>> listTask() throws IOException
    {
        return RestResponse.success(taskService.createTaskQuery().list().stream().map(item -> item.getId()).collect(Collectors.toList()));
    }

    @DeleteMapping("/{taskId}")
    public void delete(@PathVariable String taskId)
    {
        taskService.deleteTask(taskId);
    }

}
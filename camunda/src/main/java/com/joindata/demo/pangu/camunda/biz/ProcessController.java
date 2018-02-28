package com.joindata.demo.pangu.camunda.biz;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process")
public class ProcessController
{
    @Autowired
    private RuntimeService runtimeService;

    @PostMapping("/")
    public Object[] listProcess()
    {
        return runtimeService.createProcessInstanceQuery().list().stream().map(item -> item.getId()).toArray();
    }

}
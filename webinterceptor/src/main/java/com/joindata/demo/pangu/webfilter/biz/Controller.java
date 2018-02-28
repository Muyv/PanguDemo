package com.joindata.demo.pangu.webfilter.biz;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.demo.pangu.webfilter.biz.param.ModifyParam;
import com.joindata.inf.common.util.basic.ArrayUtil;

@RestController
@RequestMapping("/foo")
public class Controller
{
    @GetMapping("/bar/")
    public String[] list(@RequestParam String append)
    {
        return ArrayUtil.make("A", "B", "C", "D", append);
    }

    @PostMapping("/bar/")
    public void create(@RequestParam String[] items)
    {
    }

    @PutMapping("/bar/{oldValue}")
    public void modify(@PathVariable String oldValue, @RequestBody ModifyParam param)
    {
    }

    @DeleteMapping("/bar/{value}")
    public void remove(@PathVariable String value)
    {
    }

    @GetMapping("/other")
    public void other()
    {

    }
}

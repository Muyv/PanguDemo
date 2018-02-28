package com.joindata.demo.pangu.redis.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.inf.common.support.redis.component.RedisClient;

@RestController
@RequestMapping("/redis")
public class RedisController
{
    @Autowired
    private RedisClient redisClient;

    @GetMapping("/{key}")
    public String get(@PathVariable String key)
    {
        return redisClient.getString(key);
    }

    @PutMapping("/{key}")
    public void set(@PathVariable String key, @RequestParam String value)
    {
        redisClient.put(key, value);
    }
}

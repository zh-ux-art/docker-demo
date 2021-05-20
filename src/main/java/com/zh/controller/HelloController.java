package com.zh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    StringRedisTemplate redisTemplate;
    Long views=0L;
    @GetMapping("/incr")
    public String incr(){
       views = redisTemplate.opsForValue().increment("views");
        return "views"+views;
    }
    @GetMapping("/desc")
    public String desc(){
        views = redisTemplate.opsForValue().decrement("views");
        return "views:"+views;
    }
}

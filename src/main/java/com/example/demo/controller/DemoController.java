package com.example.demo.controller;

import com.example.demo.mapper.DemoMapper;
import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@Controller
public class DemoController {

    @Autowired
    DemoMapper demoMapper;

    @Autowired
    UserMapper userMapper;



    @ResponseBody
    @RequestMapping(path = "/queryInfo")
    public List<User> queryInfo(){
        List<User> users = demoMapper.queryInfo();
        log.info(users.toString());
        return  users;
    }
}

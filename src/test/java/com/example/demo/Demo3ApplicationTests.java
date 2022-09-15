package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
/*@SpringBootTest*/
class Demo3ApplicationTests {

    @Resource
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("hello","world");
        valueOperations.set("hello1","world1");
        valueOperations.set("hello2","world2");
        Object hello = valueOperations.get("hello");
        redisTemplate.delete("hello");
        redisTemplate.delete("hello1");
        redisTemplate.delete("hello2");
        log.info(hello.toString());
    }

    @Test
    void testDemo(){
        assertEquals(1,1);
        System.out.println("1111");
    }

}

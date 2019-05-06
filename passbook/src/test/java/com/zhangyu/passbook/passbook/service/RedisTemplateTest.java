//zhangyu de code
package com.zhangyu.passbook.passbook.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTest {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Test
    public void testRedisTemplate(){
        //redis flushall 比较危险
        redisTemplate.execute((RedisCallback<Object>) connection ->{
            connection.flushAll();
            return null;
        });

        assert redisTemplate.opsForValue().get("name")==null;
        redisTemplate.opsForValue().set("name","zhangyu");
        assert redisTemplate.opsForValue().get("name")!=null;
        System.out.println(redisTemplate.opsForValue().get("name"));

    }
}

package com.zjft.redis;


import com.zjft.entity.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Created by CK on 2017/8/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");

        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void setUser() {
        UserDO userDO = new UserDO();
        userDO.setUsername("wjchen");
        userDO.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiI0ZGQyNGJmMWNmZDg1MTI5MDg3NDk4MGE4ZTljOTVjNiIsInVzZXJuYW1lIjoidXNlcm5hbWUiLCJwYXNzd2QiOiJwYXNzd29yZCIsImlhdCI6MTUwMjMyNzUyNiwiaXNzIjoiempmdC5jb20ifQ.SJyeRVRD3rHTdRTQr__zUX8nOfSLdeZnZcaeq_H2Dbk");

        ValueOperations<String, UserDO> operations = redisTemplate.opsForValue();
        operations.set(userDO.getUsername(), userDO, 10, TimeUnit.SECONDS);


        System.out.println(redisTemplate.hasKey(userDO.getUsername()));
        System.out.println(operations.get(userDO.getUsername()));

        redisTemplate.delete(userDO.getUsername());
        System.out.println(redisTemplate.hasKey(userDO.getUsername()));

    }
}

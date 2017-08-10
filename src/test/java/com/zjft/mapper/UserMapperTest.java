package com.zjft.mapper;

import com.zjft.entity.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by CK on 2017/8/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper UserMapper;


    @Test
    public void testSelectByUsernamePassword() {

        System.out.println(UserMapper.selectByUsernamePassword(new UserDO("wjchen","000001")));
    }

    @Test
    public void testSelectByName() {

        System.out.println(UserMapper.selectByName("wjchen"));
    }

}

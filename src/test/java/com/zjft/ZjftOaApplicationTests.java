package com.zjft;

import com.zjft.entity.UserDO;
import com.zjft.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZjftOaApplicationTests {

	@Resource
	private UserMapper userMapper;

	@Test
	public void contextLoads() {

		UserDO u = new UserDO("wjchen","000001");

		u = userMapper.selectByUsernamePassword(u);

		System.out.println(u);
	}

}

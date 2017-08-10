package com.zjft.service.impl;

import com.zjft.entity.UserDO;
import com.zjft.mapper.UserMapper;
import com.zjft.service.ILoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * Created by CK on 2017/8/8.
 */
@Service("loginService")
public class LoginServiceImpl implements ILoginService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDO login(UserDO userDO) throws UnsupportedEncodingException {
        return userMapper.selectByUsernamePassword(userDO);

    }
}

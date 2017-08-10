package com.zjft.service;

import com.zjft.entity.UserDO;

import java.io.UnsupportedEncodingException;

/**
 * Created by CK on 2017/8/8.
 */
public interface ILoginService {
    UserDO login(UserDO userDO) throws UnsupportedEncodingException;

}

package com.zjft.mapper;

import com.zjft.entity.UserDO;
import org.springframework.stereotype.Repository;

/**
 * Created by CK on 2017/8/9.
 */
@Repository
public interface UserMapper {

    UserDO selectByUsernamePassword(UserDO userDO);

    UserDO selectByName(String username);

}

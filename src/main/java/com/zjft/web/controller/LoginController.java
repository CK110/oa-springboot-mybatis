package com.zjft.web.controller;

import com.zjft.entity.UserDO;
import com.zjft.service.ILoginService;
import com.zjft.util.JwtUtil;
import com.zjft.util.Response;
import com.zjft.util.ResponseCodeEnum;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * Created by CK on 2017/8/8.
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Resource
    private ILoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Response login(@RequestBody UserDO userDO, @RequestHeader(value="User-Agent") String userAgent) throws UnsupportedEncodingException {
        userDO.setUa(userAgent);
        UserDO u = loginService.login(userDO);
        if(u == null){
            return Response.error(ResponseCodeEnum.ERROR, "用户名或者密码不正确");
        }else{
            String token = JwtUtil.generateToken(userDO);
            u.setToken(token);
            return Response.ok(ResponseCodeEnum.SUCCESS, u);
        }
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    public Response test(){
        UserDO userDO = new UserDO("wjchen","000000000");
        return Response.ok(ResponseCodeEnum.SUCCESS, userDO);

    }
}

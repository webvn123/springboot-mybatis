package com.example.jwtsecurity.controller;

import com.example.jwtsecurity.common.CommonResult;
import com.example.jwtsecurity.common.JwtTokenUtil;
import com.example.jwtsecurity.domain.User;
import com.example.jwtsecurity.dto.LoginUserParam;
import com.example.jwtsecurity.mapper.UserMapper;
import com.example.jwtsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public CommonResult<String> login(@RequestBody LoginUserParam loginUserParam){
        User user =userService.login(loginUserParam);
        if(user == null){
            return new CommonResult<>(false,"用户名或密码错误");
        }
        String token = jwtTokenUtil.generateToken(user);
        return new CommonResult<>(token);
    }

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public void test(){

    }
}

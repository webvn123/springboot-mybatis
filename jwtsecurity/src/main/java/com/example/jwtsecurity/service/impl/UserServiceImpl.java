package com.example.jwtsecurity.service.impl;

import com.example.jwtsecurity.common.Md5Util;
import com.example.jwtsecurity.domain.User;
import com.example.jwtsecurity.dto.LoginUserParam;
import com.example.jwtsecurity.mapper.UserMapper;
import com.example.jwtsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(LoginUserParam loginUserParam) {
//        String password = Md5Util.getMD5Code(loginUserParam.getPassword());
//        loginUserParam.setPassword(password);
        User user = userMapper.selectByLoginParam(loginUserParam);
        return user;
    }
}

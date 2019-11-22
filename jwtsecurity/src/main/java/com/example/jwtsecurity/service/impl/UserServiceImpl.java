package com.example.jwtsecurity.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.jwtsecurity.domain.User;
import com.example.jwtsecurity.dto.LoginUserParam;
import com.example.jwtsecurity.mapper.UserMapper;
import com.example.jwtsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(LoginUserParam loginUserParam) {
//        String password = Md5Util.getMD5Code(loginUserParam.getPassword());
//        loginUserParam.setPassword(password);
        User user = userMapper.selectByLoginParam(loginUserParam);
        return user;
    }
    @Override
    public List<User> selectAll(){
        return userMapper.selectAll();
    }
}

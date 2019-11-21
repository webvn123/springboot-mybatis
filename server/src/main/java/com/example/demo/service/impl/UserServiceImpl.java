package com.example.demo.service.impl;

import com.example.demo.domain.LoginUser;
import com.example.demo.domain.User;
import com.example.demo.jwt.JwtCommon;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.viewModel.LevelCode;
import com.example.demo.viewModel.Status;
import com.example.demo.viewModel.VimData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    private JwtCommon jwtCommon = new JwtCommon();

    @Override
    public User selectByPrimaryKey(String id){

        return  userMapper.selectByPrimaryKey(id);
    }

   @Override
   public VimData register(User user){
        user.setId(UUID.randomUUID().toString());
        user.setStatucode(Status.Normal.toString());
        user.setCreatedate(new Date());
        user.setLevelcode(LevelCode.Normal.toString());
        return new VimData();
   }

   @Override
    public User login(LoginUser user){
        return userMapper.login(user);
   }
}

package com.example.jwtsecurity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.jwtsecurity.domain.User;
import com.example.jwtsecurity.dto.LoginUserParam;

import java.util.List;

/**
 * @author Administrator
 */
public interface UserService extends IService<User>{
    public User login(LoginUserParam loginUserParam);
    public List<User> selectAll();
}

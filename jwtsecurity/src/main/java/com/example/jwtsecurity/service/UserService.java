package com.example.jwtsecurity.service;

import com.example.jwtsecurity.domain.User;
import com.example.jwtsecurity.dto.LoginUserParam;

public interface UserService {
    public User login(LoginUserParam loginUserParam);
}

package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.viewModel.VimData;

public interface UserService {
    User selectByPrimaryKey(String id);
    VimData register(User user);
}

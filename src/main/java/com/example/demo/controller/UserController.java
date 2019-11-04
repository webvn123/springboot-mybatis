package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.example.demo.viewModel.VimData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public VimData register(@Valid @RequestBody User user) {
        return userService.register(user);
    }
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public VimData<User> test(){
        VimData<User> data = new VimData<>();
        data.setData(userService.selectByPrimaryKey("1"));
        return data;
    }
}

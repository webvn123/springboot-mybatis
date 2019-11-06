package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.jwt.JwtCommon;
import com.example.demo.jwt.UserLoginToken;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.viewModel.VimData;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private UserService userService;

    private JwtCommon tokenService = new JwtCommon();




    @UserLoginToken
    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    public User getUser(){
        return  userService.selectByPrimaryKey("1");
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Object login(@Valid @RequestBody User user) throws JSONException {
        VimData<String> data= new VimData<String>();
        User userForBase=userService.selectByPrimaryKey(user.getId());
        if(userForBase==null){
            data.setSuccess(false);
            data.setMessage("用户不存在");
            return data;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                data.setMessage("登录失败,密码错误");
                data.setSuccess(false);
                return data;
            }else {
                String token = tokenService.getToken(userForBase);
                data.setData(token);
                return data;
            }
        }
    }
}

package com.example.jwtsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.jwtsecurity.domain.User;
import com.example.jwtsecurity.dto.LoginUserParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    int deleteByPrimaryKey(String id);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByLoginParam(LoginUserParam loginUserParam);
}
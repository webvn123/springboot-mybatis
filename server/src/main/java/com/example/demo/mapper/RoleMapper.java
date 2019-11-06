package com.example.demo.mapper;

import com.example.demo.domain.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleMapper {
    /*
    删除
     */
    int deleteByPrimaryKey(String id);
    /*
     *插入
     *
     *@param Role Role
     *@return int
     */
    int insert(Role record);

    Role selectByPrimaryKey(String id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
}
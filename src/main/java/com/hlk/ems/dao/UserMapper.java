package com.hlk.ems.dao;

import com.hlk.ems.entity.user;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer memberid);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Integer memberid);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);

    List<user> selectAll();

    user selectBymember(user user);
}
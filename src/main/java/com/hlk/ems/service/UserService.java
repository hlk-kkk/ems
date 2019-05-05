package com.hlk.ems.service;


import com.hlk.ems.entity.user;

import java.util.List;

public interface UserService {
    //登录
    boolean login(user user);

    //注册
    void register(user user);

    //展示所有
    List<user> selectAll();

    //添加
    void add(user user);

    //查找
    user selectById(user user);

    //修改
    void update(user user);
}
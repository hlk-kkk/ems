package com.hlk.ems.service;


import com.hlk.ems.entity.User;

import java.util.List;

public interface UserService {
    //登录
    boolean login(User user);

    //注册
    void register(User user);

    //展示所有
    List<User> selectAll();

    //添加
    void add(User user);

    //查找
    User selectById(User user);

    //修改
    void update(User user);
}
package com.hlk.ems.service.Impl;

import com.hlk.ems.dao.UserMapper;
import com.hlk.ems.entity.User;
import com.hlk.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(User user) {
        User user1 = userMapper.selectByUser(user);
        if (user1.getUserpwd().equals(user.getUserpwd())) {
            return true;
        }
        return false;
    }

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> selectAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public void add(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public User selectById(User user) {
        User user1 = userMapper.selectByPrimaryKey(user.getUserid());
        return user1;
    }

    @Override
    public void update(User user) {
        int i = userMapper.updateByPrimaryKey(user);
    }

}

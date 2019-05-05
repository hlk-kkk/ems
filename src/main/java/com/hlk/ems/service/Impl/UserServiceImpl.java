package com.hlk.ems.service.Impl;

import com.hlk.ems.dao.UserMapper;
import com.hlk.ems.entity.user;
import com.hlk.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper memberMapper;

    @Override
    public boolean login(user user) {
        user member1 = memberMapper.selectBymember(user);
        if (member1.getmemberpwd().equals(user.getmemberpwd())) {
            return true;
        }
        return false;
    }

    @Override
    public void register(user user) {
        memberMapper.insert(user);
    }

    @Override
    public List<user> selectAll() {
        List<user> members = memberMapper.selectAll();
        return members;
    }

    @Override
    public void add(user user) {
        memberMapper.insertSelective(user);
    }

    @Override
    public user selectById(user user) {
        user member1 = memberMapper.selectByPrimaryKey(user.getmemberid());
        return member1;
    }

    @Override
    public void update(user user) {
        int i = memberMapper.updateByPrimaryKey(user);
    }

}

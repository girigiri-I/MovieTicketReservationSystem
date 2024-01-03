package com.mov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mov.entity.User;
import com.mov.service.UserService;
import com.mov.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username) {
        return userMapper.selectById(username);
    }
}





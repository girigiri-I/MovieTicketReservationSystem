package com.mov.service;

import com.mov.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {

    User login(String username);
}

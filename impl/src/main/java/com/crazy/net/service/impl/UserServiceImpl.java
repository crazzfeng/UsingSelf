package com.crazy.net.service.impl;

import com.crazy.net.dao.UserMapper;
import com.crazy.net.pojo.User;
import com.crazy.net.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    public List<User> findListWithPage(User user)
    {
        return userMapper.findListWithPage(user);
    }

    public UserMapper getUserMapper()
    {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper)
    {
        this.userMapper = userMapper;
    }
}

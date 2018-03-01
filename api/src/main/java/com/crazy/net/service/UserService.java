package com.crazy.net.service;

import com.crazy.net.pojo.User;

import java.util.List;

public interface UserService
{
    List<User> findListWithPage(User user);
}

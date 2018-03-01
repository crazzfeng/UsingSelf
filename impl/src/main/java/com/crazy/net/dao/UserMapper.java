package com.crazy.net.dao;

import com.crazy.net.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper
{
    List<User> findListWithPage(User user);
}

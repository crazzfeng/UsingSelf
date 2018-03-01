package com.crazy.net.service;

import com.crazy.net.pojo.User;
import com.crazy.net.service.UserService;
import com.crazy.net.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceTest extends BaseServiceTest
{
    @Autowired
    UserService userService;

    @Test
    public void test_findlist()
    {
        User user = new User();
        user.setGender("1");

       List<User> users = userService.findListWithPage(user);

       for (User user1 : users)
       {
           System.err.print(user1.getName());
       }
    }
}

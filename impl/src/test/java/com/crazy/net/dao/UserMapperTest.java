package com.crazy.net.dao;

import com.crazy.net.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserMapperTest extends BaseDaoTest
{
    @Autowired
    UserMapper userMapper;

    @Test
    public void test_findlist()
    {

        User user = new User();
        user.setGender("1");

        List<User> users = userMapper.findListWithPage(user);

        for (User user1 : users)
        {
            System.err.print(user1.getName());
        }
    }

}

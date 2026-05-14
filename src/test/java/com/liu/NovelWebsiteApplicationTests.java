package com.liu;

import com.liu.entity.User;
import com.liu.mapper.BookMapper;

import com.liu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NovelWebsiteApplicationTests {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = userMapper.getUserByName("admin");
        System.out.println(user);
    }

}

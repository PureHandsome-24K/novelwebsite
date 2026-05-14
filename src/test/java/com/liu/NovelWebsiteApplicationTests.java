package com.liu;

import com.liu.entity.MyBooks;
import com.liu.entity.User;
import com.liu.mapper.BookMapper;

import com.liu.mapper.MyBooksMapper;
import com.liu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NovelWebsiteApplicationTests {

    @Autowired
    MyBooksMapper myBooksMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<MyBooks> admin = myBooksMapper.queryMybooks("admin");
        for (MyBooks myBooks : admin) {
            System.out.println(myBooks);
        }

    }

}

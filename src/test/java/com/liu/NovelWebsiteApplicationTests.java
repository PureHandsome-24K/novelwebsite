package com.liu;

import com.liu.entity.Book;
import com.liu.entity.MyBooks;
import com.liu.entity.User;
import com.liu.mapper.BookMapper;

import com.liu.mapper.MyBooksMapper;
import com.liu.mapper.UserMapper;
import com.liu.service.MybooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NovelWebsiteApplicationTests {

    @Autowired
    MybooksService mybooksService;

    @Autowired
    MyBooksMapper myBooksMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        Book getbooktitle = bookMapper.getbooktitle("神秘复苏");
        System.out.println(getbooktitle);
    }

}

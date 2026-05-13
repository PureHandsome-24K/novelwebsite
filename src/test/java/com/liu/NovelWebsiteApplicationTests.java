package com.liu;

import com.liu.mapper.BookMapper;
import com.liu.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NovelWebsiteApplicationTests {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void contextLoads() {
        Book getbookbyid = bookMapper.getbookbyid(1);
        System.out.println(getbookbyid);
    }

}

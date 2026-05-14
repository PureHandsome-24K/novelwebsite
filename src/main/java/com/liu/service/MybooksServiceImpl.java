package com.liu.service;

import com.liu.entity.MyBooks;
import com.liu.mapper.MyBooksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MybooksServiceImpl implements MybooksService{
    @Autowired
    private MyBooksMapper myBooksMapper;

    @Override
    public List<MyBooks> queryMybooks(String username) {
        return myBooksMapper.queryMybooks(username);
    }

    @Override
    public int add(MyBooks myBooks) {
        return myBooksMapper.insert(myBooks);
    }
}

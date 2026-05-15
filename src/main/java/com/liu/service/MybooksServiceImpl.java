package com.liu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liu.entity.MyBooks;
import com.liu.mapper.MyBooksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public MyBooks getmybooks(String username, int bid) {
      return myBooksMapper.getmybooks(username,bid);
    }

    @Override
    public int add(MyBooks myBooks) {
        return myBooksMapper.insert(myBooks);
    }

    @Override
    public int deleteMybooks(String username, int bid) {
        return myBooksMapper.deleteMybooks(username,bid);
    }
}

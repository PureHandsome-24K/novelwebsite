package com.liu.service;

import com.liu.entity.Book;
import com.liu.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Book> getBookList() {
        return bookMapper.selectList(null);
    }

    @Override
    public Book getById(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public Book getBookByDir(String dir) {
        return bookMapper.getBookByDir(dir);
    }

    @Override
    public Book getbooktitle(String title) {
        return bookMapper.getbooktitle(title);
    }
}

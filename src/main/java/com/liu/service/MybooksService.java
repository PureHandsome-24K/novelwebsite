package com.liu.service;

import com.liu.entity.MyBooks;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MybooksService {
    List<MyBooks> queryMybooks(String username);

    int add(MyBooks myBooks);
}

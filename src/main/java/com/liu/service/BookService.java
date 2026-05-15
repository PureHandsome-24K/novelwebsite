package com.liu.service;

import com.liu.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public List<Book> getBookList();

    public Book getById(Integer id);

    Book getBookByDir(String dir);
    Book getbooktitle(String title);


}

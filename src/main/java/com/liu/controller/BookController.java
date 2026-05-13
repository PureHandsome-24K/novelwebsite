package com.liu.controller;

import com.liu.entity.Book;
import com.liu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/Home")
    public String home(Model model) {

        List<Book> bookList = bookService.getBookList();
        model.addAttribute("bookList", bookList);
        return "Home";
    }



    @GetMapping("/bookshelf")
    public String bookshelf(Model model) {
        return "Shelf";
    }

    @GetMapping("/discover")
    public String discover(Model model) {
        return "discovery";
    }
    @GetMapping("/profile")
    public String profile(Model model) {
        return "mine";
    }
}

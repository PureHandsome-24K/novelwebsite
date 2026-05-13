package com.liu.controller;

import com.liu.entity.Book;
import com.liu.entity.Shenmifusu;
import com.liu.service.BookService;
import com.liu.service.ShenMiFuSuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


@Controller
public class MainController {
    @Autowired
    ShenMiFuSuService shenMiFuSuService;
    @Autowired
    BookService bookService;
    // 访问 /main/书名  → 自动重定向到第 1 页
    @GetMapping("/main/{title}")
    public String mainWithoutPage(@PathVariable String title) {
        return "redirect:/main/" + title + "/1";
    }

    // 访问 /main/书名/页码
    @GetMapping("/main/{title}/{id}")
    public String mainWithPage(@PathVariable String title, @PathVariable int id, Model model) {
        boolean flag=true;
        Shenmifusu titlemain = shenMiFuSuService.getTitleByID(id);
        model.addAttribute("titlemain", titlemain);
        Book bookByDir = bookService.getBookByDir(title);
        model.addAttribute("currentPage", id);
        model.addAttribute("book", bookByDir);
        try {
            String content = new String(
                    Files.readAllBytes(Paths.get("src/main/resources/static/" + title + "/" + id + ".txt")),
                    "UTF-8"
            );
            boolean hasNext = new File("src/main/resources/static/" + title + "/" + (id + 1) + ".txt").exists();
            model.addAttribute("hasNext", hasNext);
            model.addAttribute("article", content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Main";
    }
}
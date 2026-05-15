package com.liu.controller;

import com.liu.entity.Book;
import com.liu.entity.MyBooks;
import com.liu.entity.Shenmifusu;
import com.liu.service.BookService;
import com.liu.service.MybooksService;
import com.liu.service.ShenMiFuSuService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.net.http.HttpRequest;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


@Controller
public class MainController {
    @Autowired
    private MybooksService mybooksService;
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
    public String mainWithPage(@PathVariable String title, @PathVariable int id, Model model, HttpServletRequest request) {
        boolean flag = true;
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
        Book bookByDir1 = bookService.getBookByDir(title);
        MyBooks getmybooks = mybooksService.getmybooks(request.getSession().getAttribute("username").toString(), bookByDir1.getId());
        if (getmybooks != null) {
            model.addAttribute("buttonText", "已添加");
        }
        return "Main";
    }


    @PostMapping("/addShelf")
    @ResponseBody
    public Map<String, Object> addShelf(@RequestParam String buttonText, @RequestParam String title, HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        System.out.println("buttonText: " + buttonText + ", title: " + title + "username: " + username);
        Map<String, Object> result = new HashMap<>();

        Book getbooktitle = bookService.getbooktitle(title);
        MyBooks getmybooks = mybooksService.getmybooks(username, getbooktitle.getId());

        if (buttonText.equals("已添加")) {
            int i = mybooksService.deleteMybooks(username, getbooktitle.getId());
            if (i > 0) {
                result.put("buttonText", "添加书架");
            }

        } else {
            int add = mybooksService.add(new MyBooks(username, getbooktitle.getId()));
            if (add > 0) {
                result.put("buttonText", "已添加");
            }
        }
        return result;
    }
}

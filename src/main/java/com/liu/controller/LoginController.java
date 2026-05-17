package com.liu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class LoginController {
    @GetMapping("/toupload")
    public String toupload(){
        return "upload";
    }
    @PostMapping("/upload")
    public String upload(@RequestParam("img") MultipartFile file, HttpServletRequest request, Model model) throws IOException {
        if (file.isEmpty()) {
            model.addAttribute("git remote add github https://github.com/PureHandsome-24K/novelwebsite.git", "文件不能为空");
            return "upload";
        }

        ClassPathResource resource = new ClassPathResource("static/img");
        String realPath = resource.getFile().getAbsolutePath();
        System.out.println(realPath);


        File dest = new File(realPath, "avatar.jpg");
        file.transferTo(dest);


        return "redirect:/Home";
    }


    @GetMapping("/noauthc")
    public String noauthc() {
        return "noauthc";
    }


}

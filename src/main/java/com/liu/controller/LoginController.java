package com.liu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class LoginController {




    @GetMapping("/noauthc")
    public String noauthc() {
        return "noauthc";
    }


}

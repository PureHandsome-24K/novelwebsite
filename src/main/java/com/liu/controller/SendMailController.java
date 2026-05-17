package com.liu.controller;

import com.liu.utils.SendMail;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SendMailController {

    @Autowired
    private SendMail sendMail;

    @PostMapping("/sendMail")
    public Map<String, Object> sendMail(@RequestParam String email, HttpServletRequest request){
        Map<String, Object> result = new HashMap<>();
        try {
            sendMail.sendMail(email, request);
            result.put("success", true);
            result.put("message", "验证码已发送");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "发送失败: " + e.getMessage());
        }
        return result;
    }
}

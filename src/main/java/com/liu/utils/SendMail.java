package com.liu.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class SendMail {
    @Autowired
    private JavaMailSenderImpl mailSender;

    public void sendMail(String guest, HttpServletRequest request){
        System.out.println("发送邮件");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("注册邮件");
        String shortUUID = GetUUId.getShortUUID();
        request.getSession().setAttribute("uuid", shortUUID);
        simpleMailMessage.setText(shortUUID);
        simpleMailMessage.setFrom("3374362441@qq.com");
        simpleMailMessage.setTo(guest);
        mailSender.send(simpleMailMessage);
    }

}

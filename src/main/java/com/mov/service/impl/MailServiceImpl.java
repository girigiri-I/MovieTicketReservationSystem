package com.mov.service.impl;

import com.mov.entity.ToEmail;
import com.mov.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendMail(ToEmail toEmail) {
        //创建简单邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        //谁发的
        message.setFrom(from);
        //谁要接收
        message.setTo(toEmail.getToUser());
        //邮件标题
        message.setSubject(toEmail.getSubject());
        //邮件内容
        message.setText(toEmail.getContent());
        //发送邮件
        javaMailSender.send(message);
    }

}

package com.mov.service;

import com.mov.entity.ToEmail;

public interface MailService {

    void sendMail(ToEmail toEmail);
}

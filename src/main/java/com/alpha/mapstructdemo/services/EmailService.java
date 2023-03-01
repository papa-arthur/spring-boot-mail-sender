package com.alpha.mapstructdemo.services;

import jakarta.mail.MessagingException;

import java.io.IOException;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);
    void sendMimeMessage(String to, String subject, String htmlContent) throws MessagingException, IOException;

}

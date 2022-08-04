package com.bootstrap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
   
   @Autowired
   private JavaMailSender sender;

   public void emailSender(String to, String subject, String message){
      SimpleMailMessage mailMessage = new SimpleMailMessage();
      mailMessage.setTo(to);
      mailMessage.setSubject(subject);
      mailMessage.setText(message);
      mailMessage.setFrom("allianoanonymous@gmail.com");
      sender.send(mailMessage);
   }
}

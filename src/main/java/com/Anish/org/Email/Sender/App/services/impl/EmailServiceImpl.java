package com.Anish.org.Email.Sender.App.services.impl;

import com.Anish.org.Email.Sender.App.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service

public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private Logger logger=LoggerFactory.getLogger(EmailServiceImpl.class);

//    public EmailServiceImpl(JavaMailSender mailSender) {
//        this.mailSender = mailSender;
//    }

    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
         simpleMailMessage.setTo(to);
         simpleMailMessage.setSubject(subject);
         simpleMailMessage.setText(message);
         simpleMailMessage.setFrom("anish.kumar20071998@gmail.com");

         mailSender.send(simpleMailMessage);
         logger.info("Email has been sent");
    }

    @Override
    public void sendEmail(String[] to, String subject, String message) {
       SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom("anish.kumar20071998@gmail.com");
        mailSender.send(simpleMailMessage);
    }

    @Override
    public void sendEmailWithHtml(String to, String subject, String htmlContent) {

        MimeMessage simpleMailMessage=mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper=new MimeMessageHelper(simpleMailMessage,true,"UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom("anish.kumar20071998@gmail.com");
            helper.setText(htmlContent,true);
            mailSender.send(simpleMailMessage);
            logger.info("Email has been sent");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendEmailWithFile(String to, String subject, String message, File file) {
         MimeMessage mimeMessage=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
            helper.setFrom("anish.kumar20071998@gmail.com");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

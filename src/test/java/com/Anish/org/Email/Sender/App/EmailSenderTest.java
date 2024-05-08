package com.Anish.org.Email.Sender.App;

import com.Anish.org.Email.Sender.App.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest

public class EmailSenderTest {


    @Autowired
    private EmailService emailService;


    @Test
    void emailSendTest(){
        System.out.println("Sending email");
        emailService.sendEmail("anish.kumar20071998@gmail.com","Email from Spring Boot","This Email is send using Spring Boot while create email service");
    }

    @Test
    void sendHtmlInEmail() {
         String html=""+
                 "<h1 style='color:red;border:1px solid red;'>Welcome Anish Kumar Sharma</h1>"+
                 "";

        emailService.sendEmailWithHtml("anish.kumar20071998@gmail.com","Email From Spring Boot",html);
    }

    @Test
    void sendEmailWithFile(){
        emailService.sendEmailWithFile("anish.kumar20071998@gmail.com",
                "Email with File","This email contains file",
                new File("D:\\Email-Sender-App\\src\\main\\resources\\static\\AnishPhotos.png")
        );
    }

    @Test
    void sendEmailWithFileWithStream(){
        File file=new File("D:\\Email-Sender-App\\src\\main\\resources\\static\\AnishPhotos.png");
        try {
            InputStream is=new FileInputStream(file);
            emailService.sendEmailWithFile("anish.kumar20071998@gmail.com",
                    "Email with File","This email contains file",is);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

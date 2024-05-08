package com.Anish.org.Email.Sender.App.services;

import java.io.File;

public interface EmailService {

    //Send email to single person
    void sendEmail(String to, String subject, String message);

    //send email to multiple person.
     void sendEmail(String[] to, String subject, String message);

    //void sendEmailWithHtml

     void sendEmailWithHtml(String to, String subject, String htmlContent);

     //void send with file
     void sendEmailWithFile(String to, String subject, String message, File file);

}

package com.Anish.org.Email.Sender.App.controller.api;

import com.Anish.org.Email.Sender.App.helper.CustomResponse;
import com.Anish.org.Email.Sender.App.helper.EmailRequest;
import com.Anish.org.Email.Sender.App.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/email")
public class Emailcontroller {

    @Autowired
    private EmailService emailService;


    //Send Email

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) {
    emailService.sendEmailWithHtml(request.getTo(),request.getSubject(), request.getMessage());
    return  ResponseEntity.ok(
            CustomResponse.builder().message("Email Send Successfully !!")
                    .httpStatus(HttpStatus.OK).success(true).build()
    );
    }

    @PostMapping("/send-with-file")
     public ResponseEntity<CustomResponse> sendWithFile(@RequestBody EmailRequest request, @RequestParam MultipartFile file) throws IOException {
       emailService.sendEmailWithFile(request.getTo(), request.getSubject(), request.getMessage(), file.getInputStream());
        return  ResponseEntity.ok(
                CustomResponse.builder().message("Email Send Successfully !!")
                        .httpStatus(HttpStatus.OK).success(true).build()
        );

    }

}

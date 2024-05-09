package com.Anish.org.Email.Sender.App.helper;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailRequest {

    private String to;

    private  String subject;

    private  String message;
}

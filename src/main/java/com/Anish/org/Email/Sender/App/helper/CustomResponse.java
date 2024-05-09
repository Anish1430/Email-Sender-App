package com.Anish.org.Email.Sender.App.helper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomResponse {

    private String message;

    private HttpStatus httpStatus;

    private boolean success=false;
}

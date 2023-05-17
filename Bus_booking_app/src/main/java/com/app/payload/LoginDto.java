package com.app.payload;

import lombok.Data;
@Data
public class LoginDto {
    private String firstNameOrEmail;
    private String password;
}

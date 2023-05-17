package com.app.payload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class UserRegistrationDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String city;

    private String email;

    private String mobile;

    private String state;

    private String country;

    private String zipCode;

    private String password;


    private MultipartFile photo;
}

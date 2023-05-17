package com.app.service;

import com.app.entities.UserRegistration;
import com.app.payload.UserRegistrationDto;

import java.io.IOException;
import java.util.List;


public interface UserService {
    UserRegistrationDto saveUserRegistration(UserRegistrationDto userRegistrationDto) throws IOException;

   List <UserRegistrationDto> getAllDetails();

    UserRegistrationDto updateById(UserRegistrationDto userRegistrationDto, long userId)throws IOException;

    void deleteById(long userId);
}

package com.app.controller;

import com.app.payload.UserRegistrationDto;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //http://localhost:8080/api/user/save
    @PostMapping("/save")
    public ResponseEntity<UserRegistrationDto> saveUser(@ModelAttribute UserRegistrationDto userRegistrationDto)throws IOException{
    UserRegistrationDto dto =userService.saveUserRegistration(userRegistrationDto);
    return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/user/allDetails
    @GetMapping("/allDetails")
    public ResponseEntity<List<UserRegistrationDto>> getAllDetails(){
        List <UserRegistrationDto> allDetails = userService.getAllDetails();
        return new ResponseEntity<>(allDetails,HttpStatus.OK);

    }


    //http://localhost:8080/api/user/userId
    @PutMapping("/{userId}")
    public ResponseEntity<UserRegistrationDto> updateById(@ModelAttribute UserRegistrationDto userRegistrationDto ,@PathVariable("userId") long userId) throws IOException{
        UserRegistrationDto dto =userService.updateById(userRegistrationDto,userId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }


    //http://localhost:8080/api/userId
    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable("userId")long userId){
        userService.deleteById(userId);
    }

}

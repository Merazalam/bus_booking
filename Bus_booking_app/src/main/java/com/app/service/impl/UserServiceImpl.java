package com.app.service.impl;

import com.app.entities.UserRegistration;
import com.app.exception.ResourceNotFoundException;
import com.app.payload.UserRegistrationDto;
import com.app.repository.UserRepository;
import com.app.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
   private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserRegistrationDto saveUserRegistration(UserRegistrationDto userRegistrationDto) throws IOException {
        UserRegistration userRegistration = modelMapper.map(userRegistrationDto, UserRegistration.class);
        if(userRegistrationDto.getPhoto()!=null && !userRegistrationDto.getPhoto().isEmpty()){
             userRegistration.setPhoto(userRegistrationDto.getPhoto().getBytes());
        }
        UserRegistration savedUserReg = userRepository.save(userRegistration);
        UserRegistrationDto dto = modelMapper.map(savedUserReg, UserRegistrationDto.class);
        return dto;
    }

    @Override
    public List<UserRegistrationDto> getAllDetails() {
        List<UserRegistration> userRegistrationList = userRepository.findAll();
        List<UserRegistrationDto> registrationDtoList = userRegistrationList.stream().map(dto -> modelMapper.map(dto, UserRegistrationDto.class)).collect(Collectors.toList());
        return registrationDtoList;
    }

    @Override
    public UserRegistrationDto updateById(UserRegistrationDto userRegistrationDto, long userId) throws IOException{
        UserRegistration userRegistration = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("user", "id", userId)
        );

        UserRegistration userRegistration1 = modelMapper.map(userRegistrationDto, UserRegistration.class);
        if(userRegistrationDto.getPhoto()!=null && !userRegistrationDto.getPhoto().isEmpty()){
            userRegistration.setPhoto(userRegistrationDto.getPhoto().getBytes());
        }
        UserRegistration savedUserReg = userRepository.save(userRegistration);
        UserRegistrationDto dto = modelMapper.map(savedUserReg, UserRegistrationDto.class);
        return dto;
    }

    @Override
    public void deleteById(long userId) {
        UserRegistration userRegistration = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("user", "id", userId)
        );
        userRepository.deleteById(userId);
    }


}

package com.shree.librarysystem.controller;

import com.shree.librarysystem.dto.UserDto;
import com.shree.librarysystem.entity.User;
import com.shree.librarysystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDto = userService.getAllUsers();

        return new ResponseEntity<>(userDto
                , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
//        User user = modelMapper.map(userDto, User.class);
        UserDto createdUser = userService.createUser(userDto);
//        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}

package com.shree.librarysystem.service;

import com.shree.librarysystem.dto.UserDto;
import com.shree.librarysystem.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto createUser(UserDto userDto);
}

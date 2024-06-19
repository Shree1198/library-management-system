package com.shree.librarysystem.service;

import com.shree.librarysystem.dto.BookDto;
import com.shree.librarysystem.dto.UserDto;
import com.shree.librarysystem.entity.Book;
import com.shree.librarysystem.entity.User;
import com.shree.librarysystem.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
//        List<UserDto> userDto = users.stream()
//                .map(user -> modelMapper.map(user, UserDto.class))
//                .collect(Collectors.toList());
        return users
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public UserDto createUser(UserDto userDto) {
        User user = convertToEntity(userDto);
        return convertToDto(userRepository.save(user));
    }

    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private User convertToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
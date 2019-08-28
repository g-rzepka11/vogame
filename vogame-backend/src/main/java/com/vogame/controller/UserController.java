package com.vogame.controller;

import com.vogame.dto.UserDTO;
import com.vogame.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/users/{id}")
    public UserDTO replaceEmployee(@PathVariable Long id) {
        return modelMapper.map(userRepository.findById(id).get(), UserDTO.class);
    }
}

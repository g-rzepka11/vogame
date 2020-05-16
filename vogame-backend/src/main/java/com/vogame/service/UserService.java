package com.vogame.service;

import com.vogame.dto.UserDTO;
import com.vogame.entity.User;
import com.vogame.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        return modelMapper.map(userRepository.findById(id).get(), UserDTO.class);
    }

    public UserDTO getUserByEmail(String email) {

        User user = userRepository.findFirstByEmail(email);

        if(user == null) {
            User newUser = new User();
            newUser.setEmail(email);
            user = userRepository.save(newUser);
        }

        return modelMapper.map(user, UserDTO.class);
    }

}

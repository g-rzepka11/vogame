package com.vogame.service;

import com.vogame.dto.user.UserDTO;
import com.vogame.dto.user.response.GetUserByEmailResponse;
import com.vogame.dto.user.response.GetUserByIdResponse;
import com.vogame.dto.user.response.GetUsersResponse;
import com.vogame.dto.user.response.IsUserEmailExistsResponse;
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

    public GetUsersResponse getUsers() {
        return GetUsersResponse.builder().payload(userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList())).build();
    }

    public GetUserByIdResponse getUserById(Long id) {
        return GetUserByIdResponse.builder()
                .payload(modelMapper.map(userRepository.findById(id).get(), UserDTO.class)).build();
    }

    public GetUserByEmailResponse getUserByEmail(String email) {

        User user = userRepository.findFirstByEmail(email);

        if(user == null) {
            User newUser = new User();
            newUser.setEmail(email);
            user = userRepository.save(newUser);
        }

        return GetUserByEmailResponse.builder().payload(modelMapper.map(user, UserDTO.class)).build();
    }

    public IsUserEmailExistsResponse isUserEmailExists(String email) {
        return IsUserEmailExistsResponse.builder().payload(userRepository.existsByEmail(email)).build();
    }

}

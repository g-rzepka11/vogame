package com.vogame.controller;

import com.vogame.dto.user.response.GetUserByEmailResponse;
import com.vogame.dto.user.response.GetUserByIdResponse;
import com.vogame.dto.user.response.GetUsersResponse;
import com.vogame.dto.user.response.IsUserEmailExistsResponse;
import com.vogame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<GetUsersResponse> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<GetUserByIdResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<GetUserByEmailResponse> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @GetMapping("/emailExists/{email}")
    public ResponseEntity<IsUserEmailExistsResponse> isUserEmailExists(@PathVariable String email) {
        return ResponseEntity.ok(userService.isUserEmailExists(email));
    }
}

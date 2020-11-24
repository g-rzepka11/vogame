package com.vogame.controller;

import com.vogame.dto.common.AbstractVogameResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<AbstractVogameResponse> login() {
        return ResponseEntity.ok(AbstractVogameResponse.AbstractVogameResponseBuilder().build());
    }
}

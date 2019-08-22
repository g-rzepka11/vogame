package com.vogame.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
}

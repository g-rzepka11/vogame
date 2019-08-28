package com.vogame.dto;

import lombok.Data;

@Data
public class GameDTO {
    private Long id;
    private String name;
    private Long owner;
    private String status;
    private Long currentUser;
    private Long wordPackageId;
    private Long nextWord;
}

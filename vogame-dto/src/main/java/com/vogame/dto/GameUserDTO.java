package com.vogame.dto;

import lombok.Data;

@Data
public class GameUserDTO {
    private Long id;
    private Long gameId;
    private Long userId;
    private Boolean moderator;
}

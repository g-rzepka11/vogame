package com.vogame.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GameWordDTO {
    private Long id;
    private Long gameId;
    private Long wordId;
    private String status;
    private Long userId;
    private BigDecimal score;
}

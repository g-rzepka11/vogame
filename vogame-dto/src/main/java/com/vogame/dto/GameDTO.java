package com.vogame.dto;

import com.vogame.dto.word.WordDTO;
import lombok.Data;

@Data
public class GameDTO {
    private Long id;
    private String name;
    private Long owner;
    private String status;
    private Long currentUser;
    private Long wordPackageId;
    private WordDTO word;
}

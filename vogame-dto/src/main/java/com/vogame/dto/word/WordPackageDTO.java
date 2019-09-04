package com.vogame.dto.word;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class WordPackageDTO {
    private Long id;
    private String wordPackageName;
    private Boolean isPrivate;
    private Long userId;
    private Date createdAt;
    private String status;
    private Set<WordDTO> words;
}

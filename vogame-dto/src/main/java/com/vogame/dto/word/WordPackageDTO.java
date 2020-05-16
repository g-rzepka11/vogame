package com.vogame.dto.word;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class WordPackageDTO implements Serializable {
    private Long id;
    private String wordPackageName;
    private Boolean isPrivate;
    private Long userId;
    private Date createdAt;
    private String status;
    private List<WordDTO> words;
}

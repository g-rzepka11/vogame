package com.vogame.dto;

import lombok.Data;

import java.util.Date;

@Data
public class WordPackageDataDTO {
    private Long id;
    private String wordPackageName;
    private Boolean isPrivate;
    private Long userId;
    private Date createdAt;
    private String status;
}

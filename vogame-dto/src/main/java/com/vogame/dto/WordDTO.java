package com.vogame.dto;

import lombok.Data;

@Data
public class WordDTO {
    private Long id;
    private String text;
    private Long wordPackageId;
}

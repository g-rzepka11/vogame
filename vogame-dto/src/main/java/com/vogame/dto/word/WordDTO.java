package com.vogame.dto.word;

import lombok.Data;

import java.util.Set;

@Data
public class WordDTO {
    private Long id;
    private String text;
    private Long wordPackageId;
    private Set<TranslationDTO> translations;
}

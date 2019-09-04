package com.vogame.dto.word;

import lombok.Data;

@Data
public class TranslationDTO {
    private Long id;
    private String text;
    private String partOfSpeech;
    private Long wordId;
}

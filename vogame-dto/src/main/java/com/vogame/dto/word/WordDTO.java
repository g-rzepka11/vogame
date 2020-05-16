package com.vogame.dto.word;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class WordDTO implements Serializable {
    private Long id;
    private String text;
    private Long wordPackageId;
    private String translation;
}

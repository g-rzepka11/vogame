package com.vogame.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetWordPackagesResponse {
    private List<WordPackageDataDTO> wordPackageDataDTOS;
}

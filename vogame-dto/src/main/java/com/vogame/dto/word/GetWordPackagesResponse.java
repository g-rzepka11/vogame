package com.vogame.dto.word;

import java.util.List;

public class GetWordPackagesResponse {
    private List<WordPackageDataDTO> wordPackageDataDTOS;

    public List<WordPackageDataDTO> getWordPackageDataDTOS() {
        return wordPackageDataDTOS;
    }

    public void setWordPackageDataDTOS(List<WordPackageDataDTO> wordPackageDataDTOS) {
        this.wordPackageDataDTOS = wordPackageDataDTOS;
    }
}

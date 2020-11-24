package com.vogame.dto.learn;

import java.util.List;

public class LearnUserWordsPageDTO {
    private List<LearnUserWordDTO> learnUserWordDTOS;
    private Integer pageNumber;
    private Integer totalPages;

    public List<LearnUserWordDTO> getLearnUserWordDTOS() {
        return learnUserWordDTOS;
    }

    public void setLearnUserWordDTOS(List<LearnUserWordDTO> learnUserWordDTOS) {
        this.learnUserWordDTOS = learnUserWordDTOS;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}

package com.vogame.dto.learn.response;

import com.vogame.dto.learn.LearnUserWordDTO;
import com.vogame.dto.common.AbstractVogameResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class StartLearningResponse extends AbstractVogameResponse<List<LearnUserWordDTO>> {

    public StartLearningResponse() {
    }

    @Builder
    public StartLearningResponse(List<LearnUserWordDTO> payload, AbstractVogameResponse.Error error) {
        super(payload, error);
    }
}
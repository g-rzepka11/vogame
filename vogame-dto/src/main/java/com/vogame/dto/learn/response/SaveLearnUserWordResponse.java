package com.vogame.dto.learn.response;

import com.vogame.dto.learn.LearnUserWordDTO;
import com.vogame.dto.common.AbstractVogameResponse;
import lombok.Builder;
import lombok.Data;

@Data
public class SaveLearnUserWordResponse extends AbstractVogameResponse<LearnUserWordDTO> {

    public SaveLearnUserWordResponse() {
    }

    @Builder
    public SaveLearnUserWordResponse(LearnUserWordDTO payload, AbstractVogameResponse.Error error) {
        super(payload, error);
    }
}

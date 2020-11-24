package com.vogame.dto.learn.response;

import com.vogame.dto.learn.LearnUserWordsPageDTO;
import com.vogame.dto.common.AbstractVogameResponse;
import lombok.Builder;
import lombok.Data;

@Data
public class GetLearnUserWordsPageResponse extends AbstractVogameResponse<LearnUserWordsPageDTO> {

    public GetLearnUserWordsPageResponse() {
    }

    @Builder
    public GetLearnUserWordsPageResponse(LearnUserWordsPageDTO payload, AbstractVogameResponse.Error error) {
        super(payload, error);
    }
}
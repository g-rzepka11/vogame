package com.vogame.dto.learn.response;

import com.vogame.dto.learn.LearnConfigDTO;
import com.vogame.dto.common.AbstractVogameResponse;
import lombok.Builder;
import lombok.Data;

@Data
public class GetLearnConfigResponse extends AbstractVogameResponse<LearnConfigDTO> {

    public GetLearnConfigResponse() {
    }

    @Builder
    public GetLearnConfigResponse(LearnConfigDTO payload, AbstractVogameResponse.Error error) {
        super(payload, error);
    }
}

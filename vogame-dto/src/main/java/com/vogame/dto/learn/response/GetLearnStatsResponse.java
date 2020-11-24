package com.vogame.dto.learn.response;

import com.vogame.dto.learn.LearnStatsDTO;
import com.vogame.dto.common.AbstractVogameResponse;
import lombok.Builder;
import lombok.Data;

@Data
public class GetLearnStatsResponse extends AbstractVogameResponse<LearnStatsDTO> {

    public GetLearnStatsResponse() {
    }

    @Builder
    public GetLearnStatsResponse(LearnStatsDTO payload, AbstractVogameResponse.Error error) {
        super(payload, error);
    }
}

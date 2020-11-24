package com.vogame.dto.game.response;

import com.vogame.dto.common.AbstractVogameResponse;
import lombok.Builder;

public class CreateNewGameResponse extends AbstractVogameResponse<Long> {

    public CreateNewGameResponse() {
    }

    @Builder
    public CreateNewGameResponse(Long payload, AbstractVogameResponse.Error error) {
        super(payload, error);
    }
}
